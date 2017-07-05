package swc.stocks

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer

import akka.http.scaladsl.server.Directives._

import scala.io.StdIn

object Server extends App with Marshaller{

  implicit val system = ActorSystem("StocksRest")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  private val interface = "localhost"
  private val port = 9191

  val routes: Route =
    path ("stocks") {
      pathEndOrSingleSlash {
        get {
         complete(StockService.fetchStocks())
        }
      }
    } ~ path("stocks" / "portfolio" / IntNumber) { id =>
      get {
        complete(StockService.fetchUserPortolio(id))
      }
    } ~ path("stocks" / "portfolio" / IntNumber / Remaining)  { (id, code) =>
      put {
        complete(StockService.addToUserPortfolio(id, code))
      }
    } ~ path("stocks" / "portfolio" / IntNumber/ Remaining) { (id, code) =>
      delete {
        complete(StockService.removeFromUserPortfolio(id, code))
      }
    }

  val bindingFuture = Http().bindAndHandle(routes, interface, port)

  println(s"Server online at http://${interface}:${port}/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done
}
