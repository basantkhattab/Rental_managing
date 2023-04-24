package packages
import java.io.*
import scala.collection.mutable.*
import java.time.*
import scala.io.Source

class RentalManager:
  val itemsrecord= ListBuffer[Item]()
  val items = ListBuffer[Item]()
  val renters = ListBuffer[Renter]()
  val rentalRecords = ListBuffer[RentalRecord]()
  val reservations = ListBuffer[Reservation]()
  val renteditems= ListBuffer[RentalRecord]()
  val itemtypes= items.map(_.itemType).distinct.toList

  def getItemsByType(itemType: String): List[Item] =
    items.filter(_.itemType == itemType).toList

  def addItem(item: Item): Unit =
    itemsrecord += item
    items += item


  def removeItem(itemname: String,itemcount: Int): Unit =
    val finditem = items.find(itemname==_.name)
    val findcount = finditem.find(itemcount==_.availableCount)
    if findcount.nonEmpty then
      items -= findcount.head


      
  /*def removeItem(item: Item): Unit =
    items-=item
*/
  def rentItem(renter: Renter, itemname: String, count: Int, rentStart: LocalDateTime, rentEnd: LocalDateTime): RentalRecord =
// Check if item is available
// Calculate cost based on rental period
// Update available count of item
// Create rental record and add to renter's rental records
// Return the rental record
    val duration = Duration.between(rentStart, rentEnd)
    val finditem= items.find(itemname==_.name)
    val price= finditem.head.getPrice(duration)
    val rentalRecord = new RentalRecord(renter,finditem.head,count,rentStart,rentEnd,price)
    val itemRented=  items.find(_.name==rentalRecord.item.name)
    if itemRented.nonEmpty && itemRented.get.availableCount>=count then
      finditem.head.availableCount-=count
      renter.addRentalRecord(rentalRecord)
      renteditems += rentalRecord
      rentalRecords += rentalRecord
    rentalRecord


  def returnItem(rentalRecord: RentalRecord): RentalRecord =
// Update available count of item
// Remove rental record from renter's rental records
// Add rental record to rental records
// Return the rental record
    val itemRented = items.find(n=>n.name == rentalRecord.item.name)
    if itemRented.nonEmpty then
      itemRented.get.availableCount += rentalRecord.count
      rentalRecord.renter.removeRentalRecord(rentalRecord)
      renteditems -= rentalRecord
    rentalRecord


  def addRenter(renter: Renter): Unit = 
    renters += renter

  def removeRenter(renter: Renter): Unit = 
    renters -= renter

  def addReservation(renter: Renter, itemname: String, count: Int, rentStart: LocalDateTime, rentEnd: LocalDateTime): Unit =
// Check if all items in reservation are available for the rental period
// Add reservation to reservations list
    val duration = Duration.between(rentStart, rentEnd)
    val finditem= items.find(itemname==_.name)
    val price= finditem.head.getPrice(duration)
    val reservation= new Reservation(renter,finditem.head,count,rentStart, rentEnd)
    if finditem.nonEmpty && finditem.get.availableCount>=count then
      finditem.head.availableCount-=count
      reservations+=reservation
      reservation



  def removeReservation(reservation: Reservation): Unit =
    reservations -= reservation

  def saveToFile(rentalRecords: ListBuffer[RentalRecord], name: String): Unit =
    val file = new File(name)
    val printwrite = new PrintWriter(file)

    rentalRecords.foreach(record => printwrite.println(
      s"${record.renter.toString},${record.item.toString},${record.count},${record.rentStart},${record.rentEnd},${record.cost}"))
    printwrite.close()

  def save(): Unit = saveToFile(rentalRecords, "rental_records.csv")

  def saveRentedItems(): Unit = saveToFile(renteditems, "rented_items.csv")



  def saveToFileItem(items: ListBuffer[Item], name: String): Unit =

    val file = new File(name)
    val printwrite = new PrintWriter(file)

    items.foreach(items => printwrite.println(s"${items.name},${items.description},${items.itemType},${items.price},${items.hourlyPrice},${items.dailyPrice},${items.weeklyPrice},${items.monthlyPrice},${items.availableCount}"))
    printwrite.close()

  def saveitemrecord(): Unit = saveToFileItem(itemsrecord, "items_record.csv")

  def saveitems(): Unit = saveToFileItem(items, "items.csv")

  def loadFromFile(name: String): ListBuffer[RentalRecord] =
    val file = new File(name)
    val source = Source.fromFile(file)
    val records = ListBuffer[RentalRecord]()

    for (line <- source.getLines())
      val values = line.split(",")
      val renter = new Renter(values(0))
      val item = itemsrecord.find(values(1)==_.name).head
      val count = values(3).toInt
      val rentStart = LocalDateTime.parse(values(4))
      val rentEnd = LocalDateTime.parse(values(5))
      val cost = values(6).toDouble

      records += new RentalRecord(renter, item, count, rentStart, rentEnd, cost)


    source.close()
    records


  def loadFromFileRentalRecords(name: String): ListBuffer[RentalRecord] =
    val file = new File(name)
    val source = Source.fromFile(file)
    val records = ListBuffer[RentalRecord]()

    for (line <- source.getLines())
      val values = line.split(",")
      val renter = new Renter(values(0))
      val item = itemsrecord.find(values(1)==_.name).head
      val count = values(3).toInt
      val rentStart = LocalDateTime.parse(values(4))
      val rentEnd = LocalDateTime.parse(values(5))
      val cost = values(6).toDouble

      records += new RentalRecord(renter, item, count, rentStart, rentEnd, cost)


    source.close()
    records

  def loadFromFileItems(name: String): ListBuffer[Item] =
    val file = new File(name)
    val source = Source.fromFile(file)
    val items = ListBuffer[Item]()

    for (line <- source.getLines())
      val value = line.split(",")
      val name=value.head
      val description=value(1)
      val itemtype= value(2)
      val cost =value(3).toDouble
      val hourlyprice=value(4).toDouble
      val dailyprice= value(5).toDouble
      val weeklyprice= value(6).toDouble
      val monthlyprice= value(7).toDouble
      val availalecount= value(8).toInt
      items += new Item(name, description, itemtype, cost, hourlyprice, dailyprice, weeklyprice, monthlyprice, availalecount)

    source.close()
    items

  def loadItem=
    itemsrecord++=loadFromFileItems("items_record.csv")
    items ++= loadFromFileItems("items.csv")

  def loadrest=
    renteditems ++= loadFromFile("rented_items.csv")
    rentalRecords ++= loadFromFileRentalRecords("rental_records.csv")


