import scala.collection.mutable.ListBuffer
object configuration {
  def buildDirectedList(inputString: String): DirectedList ={
    val charList: ListBuffer[Char] = new ListBuffer[Char]()
    var sortedList: List[Char] = List[Char]()
    //For each character in the string, force it to uppercase and check if it's a letter by checking the ASCII values.
    for (x <- 0 until inputString.length){
      if (inputString.charAt(x).toUpper.toInt >= 65 && inputString.charAt(x).toUpper.toInt <= 90) {
        charList.addOne(inputString.charAt(x).toUpper)
      }
    }
    //Remove all duplicates found in the string and sort them.
    sortedList = charList.toList.distinct.sorted
    //Create a new directed graph data structure
    val directedList: DirectedList = new DirectedList(sortedList)
    //Split the input string by "," to get all the edge nodes for each node
    val edgeArray: Array[String] = inputString.split(",")
    //Add all the edge nodes to the data structure
    for (i <- edgeArray.indices){
      directedList.addEdge(edgeArray(i).trim().charAt(0), edgeArray(i).trim().charAt(1), edgeArray(i).trim().charAt(2) - 48)
    }
    directedList
  }
}
