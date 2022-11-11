import scala.collection.mutable.ListBuffer

class SpecificRoute {

  def findDistance(route: String, directedList: DirectedList): Int ={
    val charList: ListBuffer[Char] = new ListBuffer[Char]()
    //Convert route string to char array and remove any characters that aren't letters
    for (x <- 0 until route.length){
      //Using ASCII Values to check if the char is a letter.
      if (route.charAt(x).toUpper.toInt >= 65 && route.charAt(x).toUpper.toInt <= 90) {
        charList.addOne(route.charAt(x).toUpper)
      }
    }
    var totalDistance: Int = 0
    try {
        //Traverse through the specific routes provided
        for(i <- 0 until charList.length - 1){
          totalDistance = totalDistance + directedList.directedGraph(directedList.nodeList.indexOf(charList.apply(i))).apply(directedList.nodeList.indexOf(charList.apply(i+1)))
        }
    //If no route is found catch the exception and return -1
    }catch {
        case ex: Exception => {
          return -1
        }
      }
    //Return total distance of route if no exception is thrown
    if(totalDistance == 0){
      -1
    }else{
      totalDistance
    }
  }
}
