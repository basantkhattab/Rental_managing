package packages
import scala.collection.mutable.ListBuffer
import java.time.*

class Item (val name: String, val description: String, val price: Double, val dailyPrice: Double, val weeklyPrice: Double, val monthlyPrice: Double, var availableCount: Int):
  val comments = ListBuffer[String]()
  def addComment(comment: String): Unit =
    comments += comment

  // Returns the price for renting the item for the given duration
  def getPrice(duration: Duration): Double =
      val days = duration.toDays
      val weeks = days / 7
      val months = days / 30
      if (months > 0)
          monthlyPrice * months
      else if (weeks > 0)
        weeklyPrice * weeks
      else
       dailyPrice * days




