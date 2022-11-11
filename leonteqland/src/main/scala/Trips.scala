import scala.collection.mutable.{ListBuffer, Stack}

class Trips() {
  //Private variables to be used throughout the class
  private var sourceNode: Int = 0
  private var endNode: Int = 0
  private var validTrips: Int = 0

  //Calculate the number of trips less that maxStops provided as parameter
  def getNumberOfTripsLessThan(maxStops: Int, sNode: Char, eNode: Char, directedList: DirectedList): Int = {
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
  private def buildPathsLessThan(maxStops: Int, Node: Int, stack: Stack[Int], directedList: DirectedList): Unit ={
    //Check if currentNode is the EndNode and total stops made that is tracked on the stack is less than the maximum amount of stops allowed.
    if (Node == endNode && stack.size <= maxStops){
      validTrips = validTrips + 1
    }
    //Check if maximum amount of stops has been exceeded
    if (stack.size >= maxStops){
      return
    }
    //Push current node onto stack to mark it as "Stopped At"
    stack.push(directedList.nodeList.indexOf(Node))
    //For each edgeNode that CurrentNode has call recursive function
    for ( x <- 0 until directedList.directedGraph(Node).size){
      buildPathsLessThan(maxStops, directedList.directedGraph(Node).toList(x)._1, stack, directedList)
    }
    //After traversing all routes remove the Node from the stack
    stack.pop()
  }


  //Calculate the number of trips equal to maxStops provided as parameter
  def getNumberOfTripsEqualTo(equalStops: Int, sNode: Char, eNode: Char, directedList: DirectedList): Int = {
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
  private def buildPathsEqualTo(maxStops: Int, Node: Int, stack: Stack[Int], directedList: DirectedList): Unit ={
    //Check if currentNode is the EndNode and total stops made that is tracked on the stack is equal to the maximum amount of stops allowed.
    if (Node == endNode && stack.size == maxStops){
      validTrips = validTrips + 1
    }
    //Check if maximum amount of stops has been exceeded
    if (stack.size >= maxStops){
      return
    }
    //Push current node onto stack to mark it as "Stopped At"
    stack.push(Node)
    //For each edgeNode that CurrentNode has call recursive function
    for ( x <- 0 until directedList.directedGraph(Node).size){
      buildPathsEqualTo(maxStops, directedList.directedGraph(Node).toList(x)._1, stack, directedList)
    }
    //After traversing all routes remove the Node from the stack
    stack.pop()
  }


  //Calculate the number of trips with total distance less than to maxDistance provided as parameter
  def getNumberOfTripsLessThanDistance(maxDistance: Int, sNode: Char, eNode: Char, directedList: DirectedList): Int = {
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
  private def buildPathsLessThanDistance(maxDistance: Int, distanceStack: Stack[Int], Node: Int, stack: Stack[Int], directedList: DirectedList): Unit ={
    //Check if currentNode is the EndNode and total distance is less than the maximum distance allowed
    if (Node == endNode && distanceStack.sum < maxDistance){
      validTrips = validTrips + 1
    }
    //Check if maximum distance has been exceeded
    if (distanceStack.sum >= maxDistance){
      return
    }
    //Push current node onto stack to mark it as "Stopped At"
    stack.push(Node)
    //For each edgeNode that CurrentNode has call recursive function
    for ( x <- 0 until directedList.directedGraph(Node).size){
      //For Each edgeNode push the distance to that node onto the stack
      distanceStack.push(directedList.directedGraph(Node).toList(x)._2)
      buildPathsLessThanDistance(maxDistance, distanceStack, directedList.directedGraph(Node).toList(x)._1, stack, directedList)
      //For Each edgeNode pop the distance to that node from the stack
      distanceStack.pop()
    }
    //After traversing all routes remove the Node from the stack
    stack.pop()
  }

  private val stackList: ListBuffer[Stack[Int]] = new ListBuffer[Stack[Int]]()

  def shortestRoute(sNode: Char, eNode: Char, directedList: DirectedList): Int = {
    sourceNode = directedList.nodeList.indexOf(sNode)
    endNode = directedList.nodeList.indexOf(eNode)
    val specificRoute: SpecificRoute = new SpecificRoute()
    var shortestDistance: Int = Int.MaxValue
    val stack = new Stack[Int]()
    stack.push(sourceNode)
    for ( x <- 0 until directedList.directedGraph(sourceNode).size){
      buildPathsShortestRoute(directedList.directedGraph(sourceNode).toList(x)._1, stack, directedList)
    }


    for (x <- stackList.indices){
      var temp: String = ""
      for (y <- stackList.apply(x).indices){
        temp = temp + directedList.nodeList(stackList.apply(x).pop())

      }
      temp = temp + "C"
      if (shortestDistance > specificRoute.findDistance(temp, directedList)){
        shortestDistance = specificRoute.findDistance(temp, directedList)
      }
      temp = ""
    }
    shortestDistance
  }
  // Need to solve for infinite recursion with parallel nodes
  private def buildPathsShortestRoute(Node: Int, stack: Stack[Int], directedList: DirectedList): Unit ={
    if (Node == endNode ){
      validTrips = validTrips + 1
      stackList.addOne(stack.clone().reverse)
      return
    }
    stack.push(Node)
    for ( x <- 0 until directedList.directedGraph(Node).size){
      buildPathsShortestRoute(directedList.directedGraph(Node).toList(x)._1, stack, directedList)
    }
    stack.pop()
  }
}
