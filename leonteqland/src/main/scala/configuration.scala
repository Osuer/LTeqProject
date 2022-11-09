import scala.collection.mutable.ListBuffer
object configuration {
  def buildDirectedList(map: String): DirectedList ={
    val charList: ListBuffer[Char] = new ListBuffer[Char]()
    var sortedList: List[Char] = List[Char]()
    for (x <- 0 until map.length){
      if (map.charAt(x).toUpper.toInt >= 65 && map.charAt(x).toUpper.toInt <= 90) {
        charList.addOne(map.charAt(x).toUpper)
      }
    }
    sortedList = charList.toList.distinct.sorted

    val directedList: DirectedList = new DirectedList(sortedList)

    val edgeArray: Array[String] = map.split(",")
    for (i <- edgeArray.indices){
      directedList.addEdge(edgeArray(i).trim().charAt(0), edgeArray(i).trim().charAt(1), edgeArray(i).trim().charAt(2) - 48)
    }
    directedList
  }
}
