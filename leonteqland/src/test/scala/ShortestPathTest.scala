import org.scalatest.funsuite.AnyFunSuite

class ShortestPathTest extends AnyFunSuite {
  val inputString = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"
  val directedList: DirectedList = configuration.buildDirectedList(inputString)
  val shortestPath: ShortestPath = new ShortestPath('A', 'C', directedList)
}
