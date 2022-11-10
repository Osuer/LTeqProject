import scala.collection.mutable.ListBuffer

class SpecificRoute {

  def findDistance(route: String, directedList: DirectedList): Int ={

    val charList: ListBuffer[Char] = new ListBuffer[Char]()
    for (x <- 0 until route.length){
      if (route.charAt(x).toUpper.toInt >= 65 && route.charAt(x).toUpper.toInt <= 90) {
        charList.addOne(route.charAt(x).toUpper)
      }
    }
    var totalDistance: Int = 0
    try {
        for(i <- 0 until charList.length - 1){
          totalDistance = totalDistance + directedList.directedGraph(directedList.nodeList.indexOf(charList.apply(i))).apply(directedList.nodeList.indexOf(charList.apply(i+1)))
        }
    }catch {
        case ex: Exception => {
          return -1
        }
      }
    totalDistance
  }

}
