package packages
import scala.collection.mutable.ListBuffer
import java.time.LocalDate

class Renter(val name: String, val contactInfo: String):
  val rentalRecords = ListBuffer[RentalRecord]()

  def addRentalRecord(rentalRecord: RentalRecord): Unit = 
    rentalRecords += rentalRecord
  

