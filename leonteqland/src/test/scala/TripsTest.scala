import org.scalatest.funsuite.AnyFunSuite

class TripsTest extends AnyFunSuite {
  val inputString = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"
  val directedList: DirectedList = configuration.buildDirectedList(inputString)

  val trips: Trips = new Trips()


  test("GetNumberOfTripsFromCtoCLessThan3Stops") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsLessThan(3, 'C', 'C', directedList) === 2)
  }

  test("GetNumberOfTripsFromCtoCLessThan4Stops") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsLessThan(4, 'C', 'C', directedList) === 4)
  }

  test("GetNumberOfTripsFromAtoCLessThan4Stops") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsLessThan(4, 'A', 'C', directedList) === 6)
  }

  test("GetNumberOfTripsFromAtoALessThan4Stops") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsLessThan(4, 'A', 'A', directedList) === 0)
  }

  test("GetNumberOfTripsFromAtoCEqualTo4Stops") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsEqualTo(4, 'A', 'C', directedList) === 3)
  }

  test("GetNumberOfTripsFromAtoAEqualTo4Stops") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsEqualTo(4, 'A', 'A', directedList) === 0)
  }

  test("GetNumberOfTripsFromCtoCEqualTo4Stops") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsEqualTo(4, 'C', 'C', directedList) === 2)
  }

  test("GetNumberOfTripsFromCtoCEqualTo2Stops") {
    val trips: Trips = new Trips()
    assert(trips.getNumberOfTripsEqualTo(2, 'C', 'C', directedList) === 1)
  }


}