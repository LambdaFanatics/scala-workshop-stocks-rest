package swc.stocks

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol
import swc.stocks.domain.{Stock, User}

trait Marshaller extends SprayJsonSupport with DefaultJsonProtocol{
  implicit val stockFormat = jsonFormat2(Stock)
  implicit val userFormat = jsonFormat2(User)


}
