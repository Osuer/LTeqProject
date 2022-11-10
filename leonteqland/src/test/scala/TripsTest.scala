import org.scalatest.funsuite.AnyFunSuite

class TripsTest extends AnyFunSuite {
  val inputString = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"
  val directedList: DirectedList = configuration.buildDirectedList(inputString)

  val trips: Trips = new Trips()


  test("QUESTION 6: GetNumberOfTripsFromCtoCLessThan3Stops") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsLessThan(3, 'C', 'C', directedList) === 2)
  }

  test("QUESTION 7: GetNumberOfTripsFromAtoCEqualTo4Stops") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsEqualTo(4, 'A', 'C', directedList) === 3)
  }

  test("QUESTION 10: GetNumberOfTripsFromCtoCDistanceLessThan30") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsLessThanDistance(30, 'C', 'C', directedList) === 7)
  }




  /* ================================================
                  QUESTION 6: Extra Tests
  ===================================================
   */
  test("GetNumberOfTripsFromCtoCLessThan4StopsCyclicAndParallelNodes") {
    val trips: Trips = new Trips()
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
    val trips: Trips = new Trips()
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
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsLessThan(4, 'A', 'A', directedList) === 0)
  }




  /* ================================================
                  QUESTION 7: Extra Tests
  ===================================================
   */
  test("GetNumberOfTripsFromAtoAEqualTo4StopsUnreachableNode") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsEqualTo(4, 'A', 'A', directedList) === 0)
  }

  /*
  Routes:
  1. CDCDC
  2. CDEBC
   */
  test("GetNumberOfTripsFromCtoCEqualTo4StopsCyclicAndParallelNodes") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsEqualTo(4, 'C', 'C', directedList) === 2)
  }

  /*
  Routes:
  1. CDC
   */
  test("GetNumberOfTripsFromCtoCEqualTo2StopsEdgeCase") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsEqualTo(2, 'C', 'C', directedList) === 1)
  }




  /* ================================================
                QUESTION 10: Extra Tests
  ===================================================
  */
  test("GetNumberOfTripsFromAtoCDistanceLessThan31DifferentCyclicNode") {
    val trips: Trips = new Trips()
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
    val trips: Trips = new Trips()
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
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsLessThanDistance(9, 'C', 'C', directedList) === 0)
  }

  test("GetNumberOfTripsFromCtoCDistanceLessThan20UnreachableNode") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsLessThanDistance(20, 'A', 'A', directedList) === 0)
  }


}
