package swc.stocks

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.io.StdIn

object Server extends App with StockRestApi {

  override implicit val system = ActorSystem("StocksRest")
  override implicit val materializer = ActorMaterializer()
  override implicit val executor = system.dispatcher

  private val interface = "localhost"
  private val port = 9191
//  val routes: Route = _.complete(ToResponseMarshallable.apply("Let's get started")(PredefinedToResponseMarshallers.liftMarshaller(PredefinedToEntityMarshallers.StringMarshaller)))
//  val routes: Route = _.complete("Let's get started")

//  val routes: Route =
//    path ("stocks") {
//    path ("stocks") {
//      pathEndOrSingleSlash {
//        get {
//         complete(StockService.fetchStocks())
//        }
//      }
//    } ~ path("stocks" / "portfolio" / IntNumber) { id =>
//      get {
//        complete(StockService.fetchUserPortfolio(id))
//      }
//    } ~ path("stocks" / "portfolio" / IntNumber / Remaining)  { (id, code) =>
//      put {
//        complete(StockService.addToUserPortfolio(id, code))
//      }
//    } ~ path("stocks" / "portfolio" / IntNumber/ Remaining) { (id, code) =>
//      delete {
//        complete(StockService.removeFromUserPortfolio(id, code))
//      }
//    }

  val bindingFuture = Http().bindAndHandle(routes, interface, port)

  println(s"Server online at http://${interface}:${port}/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done
}
