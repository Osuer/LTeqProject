import org.scalatest.funsuite.AnyFunSuite

class RoadMapTest extends AnyFunSuite {

  test("findDistanceOfRouteCase1") {
    assert(RoadMap.distanceOfRoute("ABC") === 9)
  }

  test("findDistanceOfRouteCase2") {
    assert(RoadMap.distanceOfRoute("AD") === 5)
  }

  test("findDistanceOfRouteCase3") {
    assert(RoadMap.distanceOfRoute("ADC") === 13)
  }

  test("findDistanceOfRouteCase4") {
    assert(RoadMap.distanceOfRoute("AEBCD") === 22)
  }

  //Need to find routes that aren't direct
  // Done for the day
  test("findDistanceOfRouteCase5") {
    assert(RoadMap.distanceOfRoute("AED") === 22)
  }

}
