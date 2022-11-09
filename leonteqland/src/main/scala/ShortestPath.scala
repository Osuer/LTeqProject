import scala.collection.mutable.{Map, Stack}
// Can look into making this a object class instead of class
class ShortestPath(sourceNode: Char, endNode: Char, graph: DirectedList) {
  var stack = new Stack[Int]()
  var distance: Array[Int] = new Array[Int](graph.directedGraph.size)
  var visited: Array[Boolean] = new Array[Boolean](graph.directedGraph.size)

  for (i <- graph.directedGraph.indices){
    distance(i) = Int.MaxValue
    visited(i) = false
  }
  distance(graph.nodeList.indexOf(sourceNode)) = 0


  for (i <- graph.directedGraph.indices){
    if (!visited(i)){
      buildPaths(i, visited, stack)
    }
  }


  while (stack.nonEmpty){
    val stackedNode: Int = stack.pop()
    if (distance(stackedNode) != Int.MaxValue){
      for (x <- 0 until graph.directedGraph(stackedNode).size){
        if(distance(graph.directedGraph(stackedNode).toList(x)._1) > distance(stackedNode) + graph.directedGraph(stackedNode).toList(x)._2){
          distance(graph.directedGraph(stackedNode).toList(x)._1) = distance(stackedNode) + graph.directedGraph(stackedNode).toList(x)._2
        }
      }
    }
  }

  println(distance(graph.nodeList.indexOf(endNode)))

  def buildPaths(node: Int, visited: Array[Boolean], stack: Stack[Int]): Unit ={
    visited(node) = true
    for (x <- 0 until graph.directedGraph(node).size){
      if(!visited(graph.directedGraph(node).toList(x)._1)){
        buildPaths(graph.directedGraph(node).toList(x)._1, visited, stack)
      }
    }
    stack.push(node)
  }






}
