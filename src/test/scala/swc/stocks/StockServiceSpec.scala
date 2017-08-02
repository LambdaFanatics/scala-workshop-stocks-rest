package swc.stocks

class StockServiceSpec extends UnitSpec {

  describe("StockService") {
    describe("method fetchStocks()") {
      it("should [eventually] fetch at least one stock") {
        //    fail
        StockService.fetchStocks() map { res => res.size should be > 0 }
      }
    }

    describe("method fetchUserPortfolio()"){}
  }



}
