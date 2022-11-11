import scala.collection.mutable.{ListBuffer, Stack}

class Trips() {
  //Private variables to be used throughout the class
  private var sourceNode: Int = 0
  private var endNode: Int = 0
  private var validTrips: Int = 0

  //Calculate the number of trips less that maxStops provided as parameter
  def getNumberOfTripsLessThan(maxStops: Int, sNode: Char, eNode: Char, directedList: DirectedList): Int = {
    validTrips = 0
    //Convert from Char to corresponding Int in nodeList
    sourceNode = directedList.nodeList.indexOf(sNode)
    endNode = directedList.nodeList.indexOf(eNode)
    //Stack to handle traversing through the graph
    val stack = new Stack[Int]()
    //Push source node on to stack
    stack.push(sourceNode)
    //For each edgeNode that SourceNode has call recursive function
    for ( x <- 0 until directedList.directedGraph(sourceNode).size){
      buildPathsLessThan(maxStops, directedList.directedGraph(sourceNode).toList(x)._1, stack, directedList)
    }
    validTrips
  }
  //Helper Function for getNumberOfTripsLessThan
  private def buildPathsLessThan(maxStops: Int, node: Int, stack: Stack[Int], directedList: DirectedList): Unit ={
    //Check if currentNode is the EndNode and total stops made that is tracked on the stack is less than the maximum amount of stops allowed.
    if (node == endNode && stack.size <= maxStops){
      validTrips = validTrips + 1
    }
    //Check if maximum amount of stops has been exceeded
    if (stack.size >= maxStops){
      return
    }
    //Push current node onto stack to mark it as "Stopped At"
    stack.push(directedList.nodeList.indexOf(node))
    //For each edgeNode that CurrentNode has call recursive function
    for ( x <- 0 until directedList.directedGraph(node).size){
      buildPathsLessThan(maxStops, directedList.directedGraph(node).toList(x)._1, stack, directedList)
    }
    //After traversing all routes remove the Node from the stack
    stack.pop()
  }


  //Calculate the number of trips equal to maxStops provided as parameter
  def getNumberOfTripsEqualTo(equalStops: Int, sNode: Char, eNode: Char, directedList: DirectedList): Int = {
    validTrips = 0
    //Convert from Char to corresponding Int in nodeList
    sourceNode = directedList.nodeList.indexOf(sNode)
    endNode = directedList.nodeList.indexOf(eNode)
    //Stack to handle traversing through the graph
    val stack = new Stack[Int]()
    //Push start node on to stack
    stack.push(sourceNode)
    //For each edgeNode that SourceNode has call recursive function
    for ( x <- 0 until directedList.directedGraph(sourceNode).size){
      buildPathsEqualTo(equalStops, directedList.directedGraph(sourceNode).toList(x)._1, stack, directedList)
    }
    validTrips
  }
  //Helper Function for getNumberOfTripsEqualTo
  private def buildPathsEqualTo(maxStops: Int, node: Int, stack: Stack[Int], directedList: DirectedList): Unit ={
    //Check if currentNode is the EndNode and total stops made that is tracked on the stack is equal to the maximum amount of stops allowed.
    if (node == endNode && stack.size == maxStops){
      validTrips = validTrips + 1
    }
    //Check if maximum amount of stops has been exceeded
    if (stack.size >= maxStops){
      return
    }
    //Push current node onto stack to mark it as "Stopped At"
    stack.push(node)
    //For each edgeNode that CurrentNode has call recursive function
    for ( x <- 0 until directedList.directedGraph(node).size){
      buildPathsEqualTo(maxStops, directedList.directedGraph(node).toList(x)._1, stack, directedList)
    }
    //After traversing all routes remove the Node from the stack
    stack.pop()
  }


  //Calculate the number of trips with total distance less than to maxDistance provided as parameter
  def getNumberOfTripsLessThanDistance(maxDistance: Int, sNode: Char, eNode: Char, directedList: DirectedList): Int = {
    validTrips = 0
    //Convert from Char to corresponding Int in nodeList
    sourceNode = directedList.nodeList.indexOf(sNode)
    endNode = directedList.nodeList.indexOf(eNode)
    //Stack to handle traversing through the graph
    val stack = new Stack[Int]()
    //Stack to handle distance travelled through the graph
    val distanceStack = new Stack[Int]()
    //Push start node on to stack
    stack.push(sourceNode)
    //For each edgeNode that SourceNode has call recursive function
    for ( x <- 0 until directedList.directedGraph(sourceNode).size){
      //For Each edgeNode push the distance to that node onto the stack
      distanceStack.push(directedList.directedGraph(sourceNode).toList(x)._2)
      buildPathsLessThanDistance(maxDistance, distanceStack, directedList.directedGraph(sourceNode).toList(x)._1, stack, directedList)
      //For Each edgeNode pop the distance to that node from the stack
      distanceStack.pop()
    }
    validTrips
  }
  //Helper Function for getNumberOfTripsEqualTo
  private def buildPathsLessThanDistance(maxDistance: Int, distanceStack: Stack[Int], node: Int, stack: Stack[Int], directedList: DirectedList): Unit ={
    //Check if currentNode is the EndNode and total distance is less than the maximum distance allowed
    if (node == endNode && distanceStack.sum < maxDistance){
      validTrips = validTrips + 1
    }
    //Check if maximum distance has been exceeded
    if (distanceStack.sum >= maxDistance){
      return
    }
    //Push current node onto stack to mark it as "Stopped At"
    stack.push(node)
    //For each edgeNode that CurrentNode has call recursive function
    for ( x <- 0 until directedList.directedGraph(node).size){
      //For Each edgeNode push the distance to that node onto the stack
      distanceStack.push(directedList.directedGraph(node).toList(x)._2)
      buildPathsLessThanDistance(maxDistance, distanceStack, directedList.directedGraph(node).toList(x)._1, stack, directedList)
      //For Each edgeNode pop the distance to that node from the stack
      distanceStack.pop()
    }
    //After traversing all routes remove the Node from the stack
    stack.pop()
  }

  //Calculate the shortest route from a sourceNode to an endNode
  def shortestRoute(sNode: Char, eNode: Char, directedList: DirectedList): Int ={
    //Convert from Char to corresponding Int in nodeList
    sourceNode = directedList.nodeList.indexOf(sNode)
    endNode = directedList.nodeList.indexOf(eNode)
    //Stack to handle traversing through the graph
    val stack = new Stack[Int]()
    //Distance array to keep shortest distances from source node to end node
    val distance: Array[Int] = new Array[Int](directedList.directedGraph.size)
    //Boolean array to keep track of which nodes have already been visited
    val visited: Array[Boolean] = new Array[Boolean](directedList.directedGraph.size)
    //Initialize both arrays
    for (i <- directedList.directedGraph.indices){
      distance(i) = Int.MaxValue
      visited(i) = false
    }
    //Set the distance to the source node to 0
    //This is to kick off the initial distance calculation
    distance(sourceNode) = 0
    //For each edge node if it hasn't been visited yet go visit it by calling recursive function
    for (i <- 0 until directedList.directedGraph(sourceNode).size){
      if (!visited(directedList.directedGraph(sourceNode).toList(i)._1)){
        buildPathsForShortestRoute(directedList.directedGraph(sourceNode).toList(i)._1, visited, stack, directedList)
      }
    }
    //Push the source node to the stack
    stack.push(sourceNode)
    //While loop to check if any nodes are in the stack
    while (stack.nonEmpty){
      //Pop node from stack
      val stackedNode: Int = stack.pop()
      //If the distance to the node is not max, check all it's edge nodes.
      //This is why we set the source nodes distance to previously, because we want to start building routes from the source node first.
      if (distance(stackedNode) != Int.MaxValue){
        for (x <- 0 until directedList.directedGraph(stackedNode).size){
          //If there is an edge in the node that got popped from the stack that points to our source node
          //set the distance to the source node to MaxInt so that we can calculate the distance to it.
          if(directedList.directedGraph(stackedNode).toList(x)._1 == sourceNode && distance(sourceNode) == 0){
            distance(sourceNode) = Int.MaxValue
          }
          //If the distance from a node is larger than the current distance to that the edge + the distance from the node(s) to the edge.
          //Set the new distance.
          if(distance(directedList.directedGraph(stackedNode).toList(x)._1) > distance(stackedNode) + directedList.directedGraph(stackedNode).toList(x)._2){
            distance(directedList.directedGraph(stackedNode).toList(x)._1) = distance(stackedNode) + directedList.directedGraph(stackedNode).toList(x)._2
          }
        }
      }
    }
    if(distance(endNode) == Int.MaxValue){
      0
    }else{
      distance(endNode)
    }
  }
  //Helper Function for shortestRoute
  private def buildPathsForShortestRoute(node: Int, visited: Array[Boolean], stack: Stack[Int], directedList: DirectedList): Unit ={
    //Set node to visited
    visited(node) = true
    //For edge node if it has not been visited go visit it
    for (x <- 0 until directedList.directedGraph(node).size){
      if(!visited(directedList.directedGraph(node).toList(x)._1)){
        buildPathsForShortestRoute(directedList.directedGraph(node).toList(x)._1, visited, stack, directedList)
      }
    }
    //Push the node to the stack
    stack.push(node)
  }

}
