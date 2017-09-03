package swc.stocks

import akka.Done
import swc.stocks.domain.Stock

import scala.concurrent.Future


object StockService {

//  var stocksRegistry: Map[String, Stock] = Map.empty

  private var stocksRegistry: Map[String, Stock] = Map(
    "AAA" -> Stock("AAA", "AAA description"),
    "BBB" -> Stock("BBB", "BBB description"),
    "CCC" -> Stock("CCC", "CCC description")
  )

//  var stocksPerUser: Map[Long, Seq[Stock]] = Map.empty

  private var stocksPerUser = Map(1.toLong -> Seq(Stock("CCC", "CCC description")))

  import scala.concurrent.ExecutionContext.Implicits.global

//   def fetchStocks() : Future[Seq[Stock]] = ???
  def fetchStocks(): Future[Seq[Stock]] = Future {
    stocksRegistry.values.toList
  }

  // def fetchUserStocks(userId: Long): Future[Seq[Stock]] = ???
  def fetchUserPortfolio(userId: Long): Future[Seq[Stock]] = Future {
     stocksPerUser.getOrElse(userId, Seq.empty)
  }

  //  def addToUserPortfolio(userId: Long, code: String): Future[Done]] = ???
  def addToUserPortfolio(userId: Long, code: String): Future[Done] =  Future {
    val stock = stocksRegistry.get(code)
    stock.foreach( s => {
      val userStocks = stocksPerUser.getOrElse(userId, Seq.empty)
      stocksPerUser = stocksPerUser.updated(userId, userStocks ++ Seq(s))
    })
    Done
  }

  // def removeUserStock(userId: Long, code: String): Future[Done] = ???
  def removeFromUserPortfolio(userId: Long, code: String): Future[Done] = Future {
    Done
  }

}
