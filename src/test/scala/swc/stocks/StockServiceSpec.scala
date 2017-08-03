package swc.stocks

class StockServiceSpec extends UnitSpec {

  describe("StockService") {

    describe("method fetchStocks()") {
      it("should [eventually] fetch at least one stock") {
        // fail
        StockService.fetchStocks() map { stocks => stocks.size should be > 0 }
      }
      it("should [eventually] fetch exactly (3) stocks") {
        // fail
        StockService.fetchStocks() map { stocks => stocks.size should be (3) }
      }
    }

    describe("method fetchUserPortfolio()") {
      it("should [eventually] fetch (1) stock for user with id = 1") {
        // fail
        StockService.fetchUserPortfolio(1) map { portfolio => portfolio.size should be (1)}
      }
      it("should [eventually] fetch an empty portfolio for every other user") {
        // fail
        StockService.fetchUserPortfolio(2) map { portfolio => portfolio.size should be (0)}
      }
    }

    describe("methods add and remove from user portfolio") {
      it("should [eventually] remain unchanged when adding and removing a user stock") {
        //fail
        val userId = 2
        StockService.addToUserPortfolio(userId,"BBB") flatMap {
          _ => StockService removeFromUserPortfolio (userId, "BBB")
        } flatMap {
          _ => StockService fetchUserPortfolio userId
        } map {
          _.size should be (0)
        }
      }
    }
  }
}
