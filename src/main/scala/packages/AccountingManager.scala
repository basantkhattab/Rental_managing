package packages
import scala.collection.mutable.ListBuffer
import java.time.*

class AccountingManager:
  val transactions = ListBuffer[Double]()
  val rentalRecords = ListBuffer[RentalRecord]()
  def addTransaction(transaction: Double): Unit =
    transactions += transaction

  def getIncomeByItem(item: Item, startDate: LocalDate, endDate: LocalDate): Double =

    /*var income= 0.0
    for (rental <- rentalRecords)
      if (rental.item == item && rental.rentStart.isBefore(endDate) && rental.rentEnd.isAfter(startDate)) then
        val rentalDuration = Duration.between(
          if (rental.rentStart.isBefore(startDate)) startDate.atStartOfDay(), rental.rentStart.atStartOfDay()
            ).toDays() + Duration.between(
              rental.rentStart.atStartOfDay(), if (rental.rentEnd.isAfter(endDate)) endDate.atStartOfDay()
              else rental.rentEnd.atStartOfDay()
            ).toDays() + 1
        val rentalCost = item.getPrice(rentalDuration)
        income = income + rentalCost
    income

  val rentalManager = new RentalManager()
  var income = 0.0

  rentalManager.rentalRecords.foreach(
    rentalRecord => if (rentalRecord.item == item && rentalRecord.rentStart.isAfter(startDate) && rentalRecord.rentEnd.isBefore(endDate))
      income += rentalRecord.cost*/


    val rentalManager = new RentalManager()
    val rentalRecords = rentalManager.rentalRecords.filter(record =>
      record.item == item && record.rentStart.isBefore(endDate) && record.rentEnd.isAfter(startDate))
    rentalRecords.map(record => item.getPrice(Duration.between(record.rentStart.atStartOfDay(), record.rentEnd.atStartOfDay()))).sum

    // Calculate income for item between start_date and end_date
    // Return income



  def getIncomeByItemType(itemType: String, startDate: LocalDate, endDate: LocalDate): Double =
    // Calculate income for all items of item_type between start_date and end_date
    // Return income
    ???

  def getExpensesByItem(item: Item, startDate: LocalDate, endDate: LocalDate): Double =
    // Calculate expenses for item between start_date and end_date
    // Return expenses
    ???

  def getExpensesByItemType(itemType: String, startDate: LocalDate, endDate: LocalDate): Double =
    // Calculate expenses for all items of item_type between start_date and end_date
    // Return expenses
    ???


