import scala.collection.mutable.Stack

class Trips() {
  private var sourceNode: Int = 0
  private var endNode: Int = 0
  private var validTrips: Int = 0


  def getNumberOfTripsLessThan(maxTrips: Int, sNode: Char, eNode: Char, directedList: DirectedList): Int = {
    sourceNode = directedList.nodeList.indexOf(sNode)
    endNode = directedList.nodeList.indexOf(eNode)


    val stack = new Stack[Int]()



    for ( x <- 0 until directedList.directedGraph(sourceNode).size){
      buildPaths(maxTrips, directedList.directedGraph(sourceNode).toList(x)._1, stack, directedList)
    }

    println(validTrips)


    0
  }

  private def parEdge(maxTrips: Int, Node: Int, previousNode: Int, stack: Stack[Int]): Unit ={
    var parEdgeStack: Stack[Int] = stack.clone()
    parEdgeStack.push(previousNode)
    parEdgeStack.push(Node)
    while(parEdgeStack.size < maxTrips){
      parEdgeStack.push(previousNode)
      parEdgeStack.push(Node)
      if (parEdgeStack.size <= maxTrips){
        validTrips = validTrips + 1
      }
    }


  }
  private def buildPaths(maxTrips: Int, Node: Int, stack: Stack[Int], directedList: DirectedList): Unit ={
    if (Node == endNode && stack.size < maxTrips){
      validTrips = validTrips + 1
      var previousNode: Int = stack.pop()
      for ( x <- 0 until directedList.directedGraph(previousNode).size){
          if (directedList.directedGraph(Node).toList(x)._1 == previousNode){
            parEdge(maxTrips, Node, previousNode, stack)
          }
      }
      stack.push(previousNode)

      return
    }

    if (stack.size >= maxTrips){
      return
    }

    stack.push(Node)
    for ( x <- 0 until directedList.directedGraph(Node).size){
      buildPaths(maxTrips, directedList.directedGraph(Node).toList(x)._1, stack, directedList)
    }
    stack.pop()
  }


}
