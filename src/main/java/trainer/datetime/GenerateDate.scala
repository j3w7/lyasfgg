package trainer.datetime

import java.util.Locale.GERMAN
import java.util.Locale.GERMANY

import org.joda.time.format.DateTimeFormat

import spells.WeekDaySpellBenjamin.cv
import spells.WeekDaySpellBenjamin.mv
import spells.WeekDaySpellBenjamin.r
import utils.CalendarUtils.genDate
import utils.CalendarUtils.getMonthName
import utils.CalendarUtils.getWeekDay
import utils.RandomUtils

object DateTrainingsLoop extends App {

  while (true) {

    val dt = genDate
    print(DateTimeFormat.forPattern("dd.MM.yyyy").print(dt))
    val myAnswer = readLine

    val weekday = getWeekDay(dt, GERMAN)
//    val msg = if (myAnswer == weekday) "ok" else "no, it's a " + weekday
    println(weekday)
    println

  }

}

object MonthTrainingsLoop extends App {

  while (true) {

    val month = RandomUtils.randBetween(1, 12)
    print(getMonthName(month, GERMANY))
    readLine

    println(mv(month))
    println

  }

}
object YearTrainingsLoop extends App {

  while (true) {

    val year = RandomUtils.randBetween(1600, 2199)
    println(year)
    readLine

    val cc = year.toString.substring(0, 2).toInt
    val dy = year.toString.substring(2, 4).toInt

    val s = (cv(cc) + r(dy)) % 7

    println(s + "\n")

  }
}

object ModSevenTrainingsLoop extends App {

  while (true) {

    val num = RandomUtils.randBetween(0, 99)
    print(num)
    readLine

    val s = num % 7

    println(s + "\n")
    println
  }

}

object DivFourTrainingsLoop extends App {

  while (true) {

    val num = RandomUtils.randBetween(0, 99)
    println(num)
    readLine

    val s = Math.abs(num / 4)

    println(s + "\n")

  }

}


object DivFourModSevenTrainingsLoop extends App {

  while (true) {

    val num = RandomUtils.randBetween(0, 99)
    print(num)
    readLine

    val s = Math.abs(num / 4) % 7

    println(s + "\n")

  }

}



