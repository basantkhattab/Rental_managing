package packages
import scala.collection.mutable.ListBuffer
import java.time.{LocalDate, LocalDateTime}

class Reservation(val renter: Renter, val item: ListBuffer[Item],val count: ListBuffer[Int], val rentStart: LocalDateTime, val rentEnd: LocalDateTime)

