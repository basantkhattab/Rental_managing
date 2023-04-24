package packages
import scala.collection.mutable.ListBuffer
import java.time.*

class AccountingManager:
  
  val transactions = ListBuffer[Double]()
  val rentalRecords = ListBuffer[RentalRecord]()
  
  def addTransaction(transaction: Double): Unit =
    transactions += transaction

  def getIncomeByItem(item: Item, startDate: LocalDateTime, endDate: LocalDateTime): Double =
    val rentalManager = new RentalManager()
    val rentalRecords = rentalManager.rentalRecords.filter(record =>
    record.item == item && record.rentStart.isBefore(endDate) && record.rentEnd.isAfter(startDate))
    rentalRecords.map(record => item.getPrice(Duration.between(record.rentStart, record.rentEnd))).sum

    // Calculate income for item between start_date and end_date
    // Return income



  def getIncomeByItemType(itemtype: String, startDate: LocalDateTime, endDate: LocalDateTime): Double =
    // Calculate income for all items of item_type between start_date and end_date
    // Return income
    val rentalManager = new RentalManager()
    val rentalRecords=rentalManager.rentalRecords.filter(record=>
      record.item.itemType==itemtype && record.rentStart.isBefore(endDate) && record.rentEnd.isAfter(startDate))
    rentalRecords.foldLeft(0.0)((total, record) => total + record.cost)

  def getExpensesByItem(item: Item, startDate: LocalDateTime, endDate: LocalDateTime): Double =
    // Calculate expenses for item between start_date and end_date
    // Return expenses
    val rentalManager= new RentalManager()
    val rentalRecords= rentalManager.rentalRecords.filter(record=>
      record.item== item && record.rentStart.isBefore(endDate) && record.rentEnd.isAfter(startDate))
    rentalRecords.map(_.item.price).sum


  def getExpensesByItemType(itemType: String, startDate: LocalDateTime, endDate: LocalDateTime): Double =
    // Calculate expenses for all items of item_type between start_date and end_date
    // Return expenses
    val rentalManager= new RentalManager()
    val rentalRecords=rentalManager.rentalRecords.filter(record=>
      record.item.itemType== itemType && record.rentStart.isBefore(endDate) && record.rentEnd.isAfter(startDate))
    rentalRecords.map(_.item.price).sum





