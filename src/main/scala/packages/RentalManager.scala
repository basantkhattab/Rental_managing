package packages
import scala.collection.mutable.ListBuffer
import java.time.LocalDate

class RentalManager:
  val items = ListBuffer[Item]()
  val renters = ListBuffer[Renter]()
  val rentalRecords = ListBuffer[RentalRecord]()
  val reservations = ListBuffer[Reservation]()

  def addItem(item: Item): Unit = 
    items += item
  

  def removeItem(item: Item): Unit = 
    items -= item

  def rentItem(renter: Renter, item: Item, count: Int, rentStart: LocalDate, rentEnd: LocalDate): RentalRecord =
    ???
    // Check if item is available
    // Calculate cost based on rental period
    // Update available count of item
    // Create rental record and add to renter's rental records
    // Return the rental record
    

  def returnItem(rentalRecord: RentalRecord): RentalRecord = 
    // Update available count of item
    // Remove rental record from renter's rental records
    // Add rental record to rental records
    // Return the rental record
    ???

  def addRenter(renter: Renter): Unit = 
    renters += renter

  def removeRenter(renter: Renter): Unit = 
    renters -= renter

  def addReservation(reservation: Reservation): Unit = 
    // Check if all items in reservation are available for the rental period
    // Add reservation to reservations list
    ???

  def removeReservation(reservation: Reservation): Unit = 
    reservations -= reservation


