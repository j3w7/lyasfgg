package utils

import utils.RandomUtils.randBetween
import java.util.Locale
import java.text.DateFormatSymbols
import org.joda.time.DateTime
import org.scala_tools.time.Imports._
import org.joda.time.DateTimeConstants
import org.joda.time.LocalDate

object CalendarUtils {

  def genDate = {
    val year = randBetween(1600, 2010)
    val month = randBetween(1, 12)

    val tmp_dt = new LocalDate(year, month, 1);

    val day = randBetween(1, tmp_dt.dayOfMonth.getMaximumValue)

    new LocalDate(year, month, day);
  }

  // TODO check if +1 is correct
  def getWeekDay(dt: LocalDate, l: Locale): String = new DateFormatSymbols(l).getWeekdays()(dt.getDayOfWeek+1)

  def daysFromTo(start: LocalDate, end: LocalDate): Stream[LocalDate] =
    if (start < end)
      start #:: daysFromTo(start + 1.day, end)
    else
      Stream.Empty

  def calcNextWeekday(d: LocalDate, weekDay: Int): LocalDate = {
    var dt = d
    if (d.getDayOfWeek >= weekDay)
      dt = d.plusWeeks(1)

    return dt.withDayOfWeek(weekDay)
  }

  def main(args: Array[String]) {
    for (dt <- daysFromTo(LocalDate.now, new LocalDate(2013, 06, 02)))
      println(dt)
  }
}