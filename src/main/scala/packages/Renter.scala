package packages
import scala.collection.mutable.ListBuffer
import java.time.LocalDate

class Renter(val name: String):
  val rentalRecords = ListBuffer[RentalRecord]()
  
  val comments= ListBuffer[String]()
  
  def addRentalRecord(rentalRecord: RentalRecord): Unit =
    rentalRecords += rentalRecord
  
  def removeRentalRecord(rentalRecord: RentalRecord): Unit=
    rentalRecords -= rentalRecord
  
  def addComment(comment: String)=
    comments+=comment
    
  override def toString: String= name

