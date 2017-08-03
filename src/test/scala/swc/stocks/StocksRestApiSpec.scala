package swc.stocks

import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.model.ContentTypes._
import akka.http.scaladsl.model.StatusCodes._
import swc.stocks.domain.Stock

class StocksRestApiSpec extends UnitSpec with ScalatestRouteTest with StockRestApi {
  describe("Stocks Rest API") {
    it("should respond to a stocks query with three stocks") {
      // fail
      Get(s"/stocks") ~> routes ~> check {
        status shouldBe OK
        contentType shouldBe `application/json`
        responseAs[Seq[Stock]].size shouldBe 3
      }
    }

    it("should respond to a user id = 1 portfolio query with \"CCC\" type stock") {
      // fail
      Get(s"/stocks/portfolio/1") ~> routes ~> check {
        status shouldBe OK
        contentType shouldBe `application/json`
        responseAs[Seq[Stock]] shouldBe Seq(Stock("CCC", "CCC description"))
      }
    }

    it("should respond to a user add stock query with with success") {
      fail
    }

    it("should respond to a user remove stock query with with success") {
      fail
    }
  }
}
