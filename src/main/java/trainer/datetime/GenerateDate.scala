package trainer.datetime

import java.util.Locale._
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import utils.CalendarUtils.genDate
import utils.CalendarUtils.getWeekDay
import utils.ExecutionUtils.REPL
import utils.LocaleUtils._
import utils.RandomUtils
import spells.WeekDaySpellBenjamin._
import org.joda.time.LocalDate

object DateTrainingsLoop extends App with REPL[LocalDate, String] {

  def init() = {}

  def read: LocalDate = {
    val dt = genDate
    println(DateTimeFormat.forPattern("dd.MM.yyyy").print(dt))
    readLine
    return dt
  }

  def eval(dt: LocalDate): String = {
    return getWeekDay(dt, CHINA) + "  " +
      getWeekDay(dt, JAPAN) + "  " +
      getWeekDay(dt, KOREA) + "\n" +
      getWeekDay(dt, FRANCE) + "  " +
      getWeekDay(dt, ITALY) + "  " +
      getWeekDay(dt, SPANISH) + "\n" +
      getWeekDay(dt, INDIA) + "  " +
      getWeekDay(dt, RUSSIA) + "  " +
      getWeekDay(dt, GREECE)
  }

  def print(s: String) = println(s + "\n")

  init
  run

}

object YearTrainingsLoop extends App {

  while (true) {

    val year = RandomUtils.randBetween(1600, 2199)
    println(year)
    readLine

    val cc = year.toString.substring(0, 2).toInt
    val dy = year.toString.substring(2, 4).toInt

    val s = cv(cc) + r(dy)

    println(s + "\n")
    println(s % 7 + "\n")

  }

}

