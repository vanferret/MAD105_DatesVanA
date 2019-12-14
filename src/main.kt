import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun main() {

    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    val today = LocalDate.now()
    val formatted = today.format(formatter)

    var lastknownFullMoon: LocalDate = LocalDate.of(2019,12, 11)

    println("Today is $formatted")

    while (today.isAfter(lastknownFullMoon)) {
        lastknownFullMoon = lastknownFullMoon.plusDays(29)
    }

    val nextFullMoon = lastknownFullMoon.format(formatter)
    val daysToNextFM = today.until(lastknownFullMoon, ChronoUnit.DAYS)
    if (daysToNextFM.toInt() == 0){
        println("Full moon tonight! AHOOOOOOOO!!!!!")
    } else {
        println("The next full moon will be on $nextFullMoon")
    }

}