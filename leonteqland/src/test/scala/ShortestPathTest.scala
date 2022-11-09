import org.scalatest.funsuite.AnyFunSuite

class ShortestPathTest extends AnyFunSuite {
  var nodes: Array[Char] = Array(
    'A',
    'B',
    'C',
    'D',
    'E'
  )
  val obj = new DirectedList(nodes)

  obj.addEdge('A', 'B' , 5)
  obj.addEdge('B', 'C' , 4)
  obj.addEdge('C', 'D' , 8)
  obj.addEdge('D', 'C' , 8)
  obj.addEdge('D', 'E' , 6)
  obj.addEdge('A', 'D' , 5)
  obj.addEdge('C', 'E' , 2)
  obj.addEdge('E', 'B' , 3)
  obj.addEdge('A', 'E' , 7)

  val obj2 = new ShortestPath('A' , obj.graph)
}
