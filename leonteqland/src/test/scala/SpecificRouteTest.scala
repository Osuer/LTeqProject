import org.scalatest.funsuite.AnyFunSuite

class SpecificRouteTest extends AnyFunSuite {
  val inputString = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"
  val directedList: DirectedList = configuration.buildDirectedList(inputString)

  val specificRoute: SpecificRoute = new SpecificRoute()

  test("QUESTION 1: GetRouteDistanceABC") {
    assert(specificRoute.findDistance("ABC", directedList) === 9)
  }

  test("QUESTION 2: GetRouteDistanceAD") {
    assert(specificRoute.findDistance("AD", directedList) === 5)
  }

  test("QUESTION 3: GetRouteDistanceADC") {
    assert(specificRoute.findDistance("ADC", directedList) === 13)
  }

  test("QUESTION 4: GetRouteDistanceAEBCD") {
    assert(specificRoute.findDistance("AEBCD", directedList) === 22)
  }

  test("QUESTION 5: GetRouteDistanceAED") {
    assert(specificRoute.findDistance("AED", directedList) === -1)
  }

  test("RouteStringPassedAsStatedInSpec") {
    assert(specificRoute.findDistance("A-B-C", directedList) === 9)
  }

  test("RouteStringPassedAsLowerCase") {
    assert(specificRoute.findDistance("abc", directedList) === 9)
  }

  test("RouteStringPassedAsUnexpectedFormat") {
    assert(specificRoute.findDistance("a0B-C", directedList) === 9)
  }
}
