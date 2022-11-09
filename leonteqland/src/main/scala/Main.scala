object Main {

  def main(args: Array[String]): Unit = {
    val inputString = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7"
    val directedList: DirectedList = configuration.buildDirectedList(inputString)
    println(directedList.directedGraph)
    val shortestPath: ShortestPath = new ShortestPath('A', 'C', directedList)
  }

}
