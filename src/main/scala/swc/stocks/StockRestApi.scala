package swc.stocks

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.Materializer

import scala.concurrent.ExecutionContextExecutor

trait StockRestApi extends Marshaller {
  implicit val system: ActorSystem

  implicit def executor: ExecutionContextExecutor

  implicit val materializer: Materializer

  val routes: Route =
    path("stocks") {
      pathEndOrSingleSlash {
        get {
          complete(StockService.fetchStocks())
        }
      }
    } ~ path("stocks" / "portfolio" / IntNumber) { id =>
      get {
        complete(StockService.fetchUserPortfolio(id))
      }
    } ~ path("stocks" / "portfolio" / IntNumber / Remaining) { (id, code) =>
      put {
        complete(StockService.addToUserPortfolio(id, code))
      }
    } ~ path("stocks" / "portfolio" / IntNumber / Remaining) { (id, code) =>
      delete {
        complete(StockService.removeFromUserPortfolio(id, code))
      }
    }
}
