package packages
import scala.collection.mutable.ListBuffer
import java.time.{LocalDate, LocalDateTime}

class Reservation(val renter: Renter, val item: Item,val count: Int, val rentStart: LocalDateTime, val rentEnd: LocalDateTime)

