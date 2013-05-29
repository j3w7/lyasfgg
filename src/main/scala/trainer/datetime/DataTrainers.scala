package trainer.datetime

import java.util.Locale.GERMAN
import java.util.Locale.GERMANY
import scala.collection.immutable.HashSet
import scala.math.abs
import org.joda.time.format.DateTimeFormat
import spells.WeekDaySpellBenjamin.cv
import spells.WeekDaySpellBenjamin.cvc2
import spells.WeekDaySpellBenjamin.mv
import spells.WeekDaySpellBenjamin.r
import utils.CalendarUtils.genDate
import utils.CalendarUtils.getMonthName
import utils.CalendarUtils.getWeekDay
import utils.RandomUtils
import org.joda.time.DateTime

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
    //val dy = year.toString.substring(2, 4).toInt

    val s = (cv(cc) + r(year)) % 7

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

    val s = abs(num / 4)

    println(s + "\n")

  }

}

object DivFourModSevenTrainingsLoop extends App {

  while (true) {

    val num = RandomUtils.randBetween(0, 99)
    print(num)
    readLine

    val s = abs(num / 4) % 7

    println(s + "\n")

  }
}

object DaysForWeekdayLoop extends App {

  while (true) {

    val wn = RandomUtils.randBetween(0, 6)
    val m = RandomUtils.randBetween(1, 12)
    val y = RandomUtils.randBetween(1600, 2099)
    print(getWeekDay(wn, GERMAN) + " " + m + " " + y)
    readLine

    val offs = (wn + mv(m) + cv(y) + r(y) + cvc2(y, m)) % 7

    val days = for (
      i ← 0 to 4;
      d ← List(i * 7 + offs);
      if d > 0 && d <= new DateTime(y, m, 1, 0, 0).dayOfMonth.getMaximumValue
    ) yield (d)

    println(days + "\n")

  }

}

