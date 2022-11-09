import scala.collection.immutable.HashMap

object RoadMap {

  var roadmap: Map[String, Int] = HashMap(
    "AB" -> 5,
    "BC" -> 4,
    "CD" -> 8,
    "DC" -> 8,
    "DE" -> 6,
    "AD" -> 5,
    "CE" -> 2,
    "EB" -> 3,
    "AE" -> 7
  )

  var length: Int = 0


  def printMap(): Unit ={
    println(roadmap)
  }

  def distanceOfRoute(inputString : String) : Int ={
    val charArray = inputString.toCharArray
    var result = 0
    for (i <- 0 to charArray.length - 2) {
      var tempString = ""
      tempString += charArray.apply(i) + "" + charArray.apply(i+1)
      result += roadmap.apply(tempString)
    }
    result
  }




}
