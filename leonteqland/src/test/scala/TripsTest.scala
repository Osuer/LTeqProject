import org.scalatest.funsuite.AnyFunSuite

class TripsTest extends AnyFunSuite {
  val inputString = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"
  val directedList: DirectedList = configuration.buildDirectedList(inputString)

  val trips: Trips = new Trips()

  //trips.getNumberOfTripsLessThan(3, 'C', 'C', directedList)

  trips.getNumberOfTripsLessThan(6, 'C', 'C', directedList)

}
