package packages
import scala.collection.mutable.ListBuffer
import java.time.*

class AccountingManager:
  val transactions = ListBuffer[Double]()
  val rentalRecords = ListBuffer[RentalRecord]()
  def addTransaction(transaction: Double): Unit =
    transactions += transaction

  def getIncomeByItem(item: Item, startDate: LocalDate, endDate: LocalDate): Double = ???

    /*var time = startDate.datesUntil(endDate).toList
    if time = 1 then item.dailyPrice*time
    else if time%7 then item.weeklyPrice*time
    else if time%30 then item.monthlyPrice*time else throw*/
    /*var income= 0.0
    for (rental <- rentalRecords)
        if (rental.item == item && rental.rentStart.isBefore(endDate) && rental.rentEnd.isAfter(startDate))
          val rentalDuration = Duration.between(
            if (rental.rentStart.isBefore(startDate)) startDate.atStartOfDay(), rental.rentStart.atStartOfDay()
            ).toDays() + Duration.between(
                rental.rentStart.atStartOfDay(), if (rental.rentEnd.isAfter(endDate)) endDate.atStartOfDay()
                else rental.rentEnd.atStartOfDay()
            ).toDays() + 1
        else throw

            val rentalCost = item.getPrice(rentalDuration)
            income += rentalCost

    income*/







    // Calculate income for item between start_date and end_date
    // Return income
    ???





    // Calculate income for item between start_date and end_date
    // Return income
    ???

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


