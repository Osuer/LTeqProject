import scala.collection.mutable.Map
class DirectedList(nodes: List[Char]) {

  val nodeList: List[Char] = nodes
  //Create a list of Maps
  //These Maps contain all the Edge Nodes for each Node provided in the constructor
  //List.fill(nodes.length) is needed so that the size of the list is known and out of bounds exceptions do not happen
  //Each index in the list is initialized to an Empty Map
  val directedGraph: List[Map[Int, Int]] = List.fill(nodes.length)(Map())

  //Adds a Map entry that contains the Edge Node and distance to that Node for the Source Node specified
  def addEdge(sourceNode: Char, edgeNode: Char, distance: Int): Unit ={
    directedGraph(nodes.indexOf(sourceNode)).put(nodes.indexOf(edgeNode), distance)
  }
}
