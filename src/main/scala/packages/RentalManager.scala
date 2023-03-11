package packages
import scala.collection.mutable.*
import java.time.*

class RentalManager:
  val items = ListBuffer[Item]()
  val renters = ListBuffer[Renter]()
  val rentalRecords = ListBuffer[RentalRecord]()
  val reservations = ListBuffer[Reservation]()

  def addItem(item: Item): Unit = 
    items += item
  

  def removeItem(item: Item): Unit = 
    items -= item

  def rentItem(renter: Renter, item: Item, count: Int, rentStart: LocalDate, rentEnd: LocalDate, cost: Double): RentalRecord =
// Check if item is available
// Calculate cost based on rental period
// Update available count of item
// Create rental record and add to renter's rental records
// Return the rental record
    val rentalRecord = RentalRecord(renter,item,count,rentStart,rentEnd,cost)
    val itemRented=  items.find(n=>n.name==rentalRecord.item.name)
    val duration = Duration.between(rentStart.atStartOfDay, rentEnd.atStartOfDay)
    val price= item.getPrice(duration)
    if itemRented.nonEmpty && itemRented.get.availableCount>=count then
      renter.addRentalRecord(rentalRecord)
      rentalRecords += rentalRecord
      rentalRecord
    else
      throw IllegalArgumentException("Item not available")


    

  def returnItem(rentalRecord: RentalRecord): RentalRecord = 
// Update available count of item
// Remove rental record from renter's rental records
// Add rental record to rental records
// Return the rental record
    val itemRented = items.find(n=>n.name == rentalRecord.item.name)
    if itemRented.nonEmpty then
      itemRented.get.availableCount += rentalRecord.count
      rentalRecord.renter.removeRentalRecord(rentalRecord)
      rentalRecords += rentalRecord
      rentalRecord
    else
      throw new IllegalArgumentException("Item not found")

  def addRenter(renter: Renter): Unit = 
    renters += renter

  def removeRenter(renter: Renter): Unit = 
    renters -= renter

  def addReservation(reservation: Reservation): Unit =
// Check if all items in reservation are available for the rental period
// Add reservation to reservations list
    val unavailableItems = reservation.items.filter(item => !items.contains(item) || item.availableCount < reservation.items.count(_==item))
    if unavailableItems.nonEmpty then
      println("The following items are not available for the specified rental period:")
    else
      reservation.items.foreach(item => item.availableCount -= reservation.items.count(_ == item))
      reservations += reservation
      println("Reservation added successfully.")

  def removeReservation(reservation: Reservation): Unit =
    reservations -= reservation


