package swc.stocks

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer

import scala.io.StdIn

object Server extends App {

  implicit val system = ActorSystem("StocksRest")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  private val interface = "localhost"
  private val port = 9191

  val route: Route =  _.complete("Let's get started")

  val bindingFuture = Http().bindAndHandle(route, interface, port)

  println(s"Server online at http://${interface}:${port}/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done
}
