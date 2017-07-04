package swc.stocks

import swc.stocks.domain.Stock

import scala.concurrent.Future


object StockService {


  var stocksRegistry: Map[String, Stock] = Map.empty

//  var stocksRegistry: Map[String, Stock] = Map(
//    "AAA" -> Stock("AAA", "AAA description"),
//    "BBB" -> Stock("BBB", "BBB description"),
//    "CCC" -> Stock("CCC", "CCC description")
//  )

  var stocksPerUser: Map[Long, Seq[Stock]] = Map.empty


  import scala.concurrent.ExecutionContext.Implicits.global

  // def fetchStocks() : Future[Seq[Stock]] = ???
  def fetchStocks(): Future[Seq[Stock]] = Future {
    stocksRegistry.values.toList
  }

  def fetchUserStocks(id: Long): Future[Seq[Stock]] = Future {
     stocksPerUser.getOrElse(id, Seq.empty)
  }

  def addUserStock(): Future[Unit] = ???

  def removeUserStock(): Future[Unit] = ???

}
