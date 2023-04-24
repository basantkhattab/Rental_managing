package packages
import scala.collection.mutable.*
import java.time.*
import java.io.*

class RentalRecord(val renter: Renter, val item: Item, val count: Int, val rentStart: LocalDateTime, val rentEnd: LocalDateTime, val cost: Double):
  override def toString: String= s"$renter,$item,$count,$rentStart,$rentEnd,$cost"
  
  







