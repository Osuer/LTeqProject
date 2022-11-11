import org.scalatest.funsuite.AnyFunSuite

class TripsTest extends AnyFunSuite {
  val inputString = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"
  val directedList: DirectedList = configuration.buildDirectedList(inputString)

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




  /* ================================================
                  QUESTION 7: Extra Tests
  ===================================================
  */
  test("GetNumberOfTripsFromAtoAEqualTo4StopsUnreachableNode") {
    assert(trips.getNumberOfTripsEqualTo(4, 'A', 'A', directedList) === 0)
  }

  /*
  Routes:
  1. CDCDC
  2. CDEBC
   */
  test("GetNumberOfTripsFromCtoCEqualTo4StopsCyclicAndParallelNodes") {
    assert(trips.getNumberOfTripsEqualTo(4, 'C', 'C', directedList) === 2)
  }

  /*
  Routes:
  1. CDC
   */
  test("GetNumberOfTripsFromCtoCEqualTo2StopsEdgeCase") {
    assert(trips.getNumberOfTripsEqualTo(2, 'C', 'C', directedList) === 1)
  }




  /* ================================================
                    QUESTION 8 & 9: Extra Tests
  ===================================================
  */
  test("GetShortestRouteFromBtoE") {
    assert(trips.shortestRoute('B', 'E', directedList) === 6)
  }

  test("GetShortestRouteFromBtoD") {
    assert(trips.shortestRoute('B', 'D', directedList) === 12)
  }

  test("GetShortestRouteFromBtoC") {
    assert(trips.shortestRoute('B', 'C', directedList) === 4)
  }

  test("GetShortestRouteFromCtoC") {
    assert(trips.shortestRoute('C', 'C', directedList) === 9)
  }

  test("GetShortestRouteFromCtoB") {
    assert(trips.shortestRoute('C', 'B', directedList) === 5)
  }

  test("GetShortestRouteFromCtoD") {
    assert(trips.shortestRoute('C', 'D', directedList) === 8)
  }

  test("GetShortestRouteFromCtoE") {
    assert(trips.shortestRoute('C', 'E', directedList) === 2)
  }

  test("GetShortestRouteFromDtoD") {
    assert(trips.shortestRoute('D', 'D', directedList) === 16)
  }

  test("GetShortestRouteFromDtoC") {
    assert(trips.shortestRoute('D', 'C', directedList) === 8)
  }

  test("GetShortestRouteFromDtoB") {
    assert(trips.shortestRoute('D', 'B', directedList) === 9)
  }

  test("GetShortestRouteFromDtoE") {
    assert(trips.shortestRoute('D', 'E', directedList) === 6)
  }

  test("GetShortestRouteFromAtoB") {
    assert(trips.shortestRoute('A', 'B', directedList) === 5)
  }

  test("GetShortestRouteFromAtoD") {
    assert(trips.shortestRoute('A', 'D', directedList) === 5)
  }

  test("GetShortestRouteFromAtoE") {
    assert(trips.shortestRoute('A', 'E', directedList) === 7)
  }

  test("GetShortestRouteFromAtoAUnreachable") {
    assert(trips.shortestRoute('A', 'A', directedList) === 0)
  }

  test("GetShortestRouteFromEtoAUnreachable") {
    assert(trips.shortestRoute('E', 'A', directedList) === 0)
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
}
