import scala.collection.mutable.{Map, Stack}

class ShortestPath(sourceNode: Char, graph: List[Map[Int, Int]]) {
  var stack = new Stack[Int]()
  var distance: Array[Int] = new Array[Int](graph.size)
  var visited: Array[Boolean] = new Array[Boolean](graph.size)

  for (i <- graph.indices){
    distance(i) = Int.MaxValue
    visited(i) = false
  }
  distance(0) = 0


  for (i <- graph.indices){
    if (!visited(i)){
      buildPaths(i, visited, stack)
    }
  }


  while (stack.nonEmpty){
    val stackedNode: Int = stack.pop()
    if (distance(stackedNode) != Int.MaxValue){
      for (x <- 0 until graph(stackedNode).size){
        if(distance(graph(stackedNode).toList(x)._1) > distance(stackedNode) + graph(stackedNode).toList(x)._2){
          distance(graph(stackedNode).toList(x)._1) = distance(stackedNode) + graph(stackedNode).toList(x)._2
        }
      }
    }
  }

  for (i <- graph.indices){
    println(distance(i))
  }


  def buildPaths(node: Int, visited: Array[Boolean], stack: Stack[Int]): Unit ={
    visited(node) = true
    for (x <- 0 until graph(node).size){
      if(!visited(graph(node).toList(x)._1)){
        buildPaths(graph(node).toList(x)._1, visited, stack)
      }
    }
    stack.push(node)
  }






}
