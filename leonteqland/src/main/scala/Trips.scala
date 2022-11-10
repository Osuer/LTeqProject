import scala.collection.mutable.Stack

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

    //Push start node on to stack
    stack.push(directedList.nodeList.indexOf(eNode))
    //For each edgeNode that SourceNode has call recursive function
    for ( x <- 0 until directedList.directedGraph(sourceNode).size){
      buildPathsLessThan(maxStops, directedList.directedGraph(sourceNode).toList(x)._1, stack, directedList)
    }

    validTrips
  }

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
    stack.push(directedList.nodeList.indexOf(sNode))
    //For each edgeNode that SourceNode has call recursive function
    for ( x <- 0 until directedList.directedGraph(sourceNode).size){
      buildPathsEqualTo(equalStops, directedList.directedGraph(sourceNode).toList(x)._1, stack, directedList)
    }

    validTrips
  }

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

}
