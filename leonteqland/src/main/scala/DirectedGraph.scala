import scala.collection.immutable.HashMap

object DirectedGraph {

  var Nodes: List[Char] = List(
    'A',
    'B',
    'C',
    'D',
    'E'
  )

  var aEdges: Map[Char, Int] = HashMap(
    'B' -> 7,
    'D' -> 5,
    'E' -> 7
  )

  var bEdges: Map[Char, Int] = HashMap(
    'C' -> 4
  )

  var cEdges: Map[Char, Int] = HashMap(
    'D' -> 8,
    'E' -> 2,
  )

  var dEdges: Map[Char, Int] = HashMap(
    'C' -> 8,
    'E' -> 6
  )

  var eEdges: Map[Char, Int] = HashMap(
    'B' -> 3
  )


  var LeonteqlandDirectedGraph: Map[Char, Map[Char, Int]] = HashMap(
    'A' -> aEdges,
    'B' -> bEdges,
    'C' -> cEdges,
    'D' -> dEdges,
    'E' -> eEdges
  )

  def printDirectedGraph(): Unit ={
    println(LeonteqlandDirectedGraph)
  }

}
