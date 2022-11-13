import org.scalatest.funsuite.AnyFunSuite

class TripsTest extends AnyFunSuite {
  val inputString = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"
  val directedList: DirectedList = configuration.buildDirectedList(inputString)
  val altInputString = "ZX4, XY3, XV3, XW4, VY6, WY2, YZ7, YW2"
  val altDirectedList: DirectedList = configuration.buildDirectedList(altInputString)
  val trips: Trips = new Trips()

  test("QUESTION 6: GetNumberOfTripsFromCtoCLessThan3Stops") {
    assert(trips.getNumberOfTripsLessThan(3, 'C', 'C', directedList) === 2)
  }

  test("QUESTION 7: GetNumberOfTripsFromAtoCEqualTo4Stops") {
    assert(trips.getNumberOfTripsEqualTo(4, 'A', 'C', directedList) === 3)
  }

  test("QUESTION 8: GetShortestRouteFromAtoC") {
    assert(trips.shortestRoute('A', 'C', directedList) === 9)
  }

  test("QUESTION 9: GetShortestRouteFromBtoB") {
    assert(trips.shortestRoute('B', 'B', directedList) === 9)
  }

  test("QUESTION 10: GetNumberOfTripsFromCtoCDistanceLessThan30") {
    assert(trips.getNumberOfTripsLessThanDistance(30, 'C', 'C', directedList) === 7)
  }




  /* ================================================
                  QUESTION 6: Extra Tests
  ===================================================
  */
  test("GetNumberOfTripsFromCtoCLessThan4StopsCyclicAndParallelNodes") {
    assert(trips.getNumberOfTripsLessThan(4, 'C', 'C', directedList) === 4)
    /*
      Routes:
      1. CDC
      2. CDCDC
      3. CDEBC
      4. CEBC
   */
  }

  test("GetNumberOfTripsFromAtoCLessThan4StopsDifferentSourceAndEndNode") {
    assert(trips.getNumberOfTripsLessThan(4, 'A', 'C', directedList) === 6)
    /*
      Routes:
      1. ABC
      2. ABCDC
      3. ABCEC
      4. ADCDC
      5. ADC
      6. AEBC
   */
  }

  test("GetNumberOfTripsFromAtoALessThan4StopsUnreachableEndNode") {
    assert(trips.getNumberOfTripsLessThan(4, 'A', 'A', directedList) === 0)
  }

  test("GetNumberOfTripsFromZtoZLessThan4StopsCyclicNodes") {
    assert(trips.getNumberOfTripsLessThan(4, 'Z', 'Z', altDirectedList) === 3)
    /*
      Routes:
      1. ZXYZ
      2. ZXVYZ
      3. ZXWYZ
   */
  }

  test("GetNumberOfTripsFromXtoYLessThan3StopsDifferentSourceAndEndNode") {
    assert(trips.getNumberOfTripsLessThan(3, 'X', 'Y', altDirectedList) === 4)
    /*
      Routes:
      1. XY
      2. XYWY
      3. XWY
      4. XVY
   */
  }




  /* ================================================
                  QUESTION 7: Extra Tests
  ===================================================
  */
  test("GetNumberOfTripsFromAtoAEqualTo4StopsUnreachableNode") {
    assert(trips.getNumberOfTripsEqualTo(4, 'A', 'A', directedList) === 0)
  }

  test("GetNumberOfTripsFromCtoCEqualTo4StopsCyclicAndParallelNodes") {
    assert(trips.getNumberOfTripsEqualTo(4, 'C', 'C', directedList) === 2)
    /*
    Routes:
    1. CDCDC
    2. CDEBC
   */
  }

  test("GetNumberOfTripsFromCtoCEqualTo2StopsEdgeCase") {
    assert(trips.getNumberOfTripsEqualTo(2, 'C', 'C', directedList) === 1)
    /*
    Routes:
    1. CDC
   */
  }

  test("GetNumberOfTripsFromYtoYEqualTo2StopsEdgeCase") {
    assert(trips.getNumberOfTripsEqualTo(2, 'Y', 'Y', altDirectedList) === 1)
    /*
    Routes:
    1. YWY
   */
  }

  test("GetNumberOfTripsFromYtoYEqualTo4CyclicAndParallelNodes") {
    assert(trips.getNumberOfTripsEqualTo(4, 'Y', 'Y', altDirectedList) === 3)
    /*
    Routes:
    1. YWYWY
    2. YZXWY
    3. YZXVY
   */
  }




  /* ================================================
                    QUESTION 8 & 9: Extra Tests
  ===================================================
  */

  test("GetShortestRouteFromCtoCCyclicNode") {
    assert(trips.shortestRoute('C', 'C', directedList) === 9)
  }

  test("GetShortestRouteFromEtoAUnreachable") {
    assert(trips.shortestRoute('E', 'A', directedList) === 0)
  }

  test("GetShortestRouteFromZtoZ") {
    assert(trips.shortestRoute('Z', 'Z', altDirectedList) === 14)
  }

  test("GetShortestRouteFromZtoW") {
    assert(trips.shortestRoute('Z', 'W', altDirectedList) === 8)
  }




  /* ================================================
                QUESTION 10: Extra Tests
  ===================================================
  */
  test("GetNumberOfTripsFromAtoCDistanceLessThan31DifferentCyclicNode") {
    assert(trips.getNumberOfTripsLessThanDistance(31, 'D', 'D', directedList) === 4)
    /*
     Routes:
     1. DCD
     2. DCEBCD
     3. DEBCD
     4. DEBCEBCD
    */
  }

  test("GetNumberOfTripsFromAtoCDistanceLessThan20DifferentSourceAndEndNode") {
    assert(trips.getNumberOfTripsLessThanDistance(20, 'A', 'C', directedList) === 5)
    /*
      Routes:
      1. ABC
      2. ABCEBC
      3. ADC
      4. ADEBC
      5. AEBC
   */
  }

  test("GetNumberOfTripsFromCtoCDistanceLessThan9EdgeCase") {
    assert(trips.getNumberOfTripsLessThanDistance(9, 'C', 'C', directedList) === 0)
  }

  test("GetNumberOfTripsFromCtoCDistanceLessThan20UnreachableNode") {
    assert(trips.getNumberOfTripsLessThanDistance(20, 'A', 'A', directedList) === 0)
  }

  test("GetNumberOfTripsFromZtoYDistanceLessThan14DifferentSourceAndEndNode") {
    assert(trips.getNumberOfTripsLessThanDistance(14, 'Z', 'Y', altDirectedList) === 4)
    /*
      Routes:
      1. ZXY
      2. ZXVY
      3. ZXWY
      4. ZXWYWY
   */
  }

  test("GetNumberOfTripsFromZtoZDistanceLessThan22CyclicNode") {
    assert(trips.getNumberOfTripsLessThanDistance(22, 'Z', 'Z', altDirectedList) === 5)
    /*
      Routes:
      1. ZXYZ
      2. ZXVYZ
      3. ZXWYZ
      4. ZXWYWYZ
      5. ZXYWYZ
   */
  }
}
