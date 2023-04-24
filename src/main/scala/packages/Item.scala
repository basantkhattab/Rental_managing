package packages
import scala.collection.mutable.ListBuffer
import java.time.*

class Item (val name: String, val description: String,val itemType: String, val price: Double, val hourlyPrice: Double, val dailyPrice: Double, val weeklyPrice: Double, val monthlyPrice: Double, var availableCount: Int):
  val comments = ListBuffer[String]()
  val itemtypecomments= ListBuffer[String]()

  def addComment(comment: String): Unit =
    comments += comment

  // Returns the price for renting the item for the given duration
  def getPrice(duration: Duration): Double =

      val days = duration.toDays
      days/30*monthlyPrice+((days%30/7*weeklyPrice))+(((days%30)%7))*dailyPrice+(((days%30)%7)/24*hourlyPrice)

  override def toString: String =s"$name,$availableCount"



