package swc.stocks

import swc.stocks.domain.Stock

import scala.concurrent.Future

object StockService {

//def fetchStocks() : Future[Seq[Stock]] = ???

  def fetchStocks() : Future[Seq[Stock]] = Future {
    Seq(
      Stock("AAA", "Stock AAA"),
      Stock("BBB", "Stock BBB"),
      Stock("CCC", "Stock CCC"))
  }

}
