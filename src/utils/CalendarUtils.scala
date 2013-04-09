package utils

import utils.RandomUtils.randBetween
import java.util.Locale
import java.text.DateFormatSymbols
import org.joda.time.DateTime
import org.scala_tools.time.Imports._
import org.joda.time.DateTimeConstants

object CalendarUtils {

  def genDate = {
    val year = randBetween(1600, 2010)
    val month = randBetween(1, 12)

    val tmp_dt = new DateTime(year, month, 1, 0, 0);

    val day = randBetween(1, tmp_dt.dayOfMonth.getMaximumValue)

    new DateTime(year, month, day, 0, 0);
  }

  def getWeekDay(dt: DateTime, l: Locale): String = new DateFormatSymbols(l).getWeekdays()(dt.getDayOfWeek)

  def daysFromTo(start: DateTime, end: DateTime): Stream[DateTime] =
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
    for (dt <- daysFromTo(DateTime.now, new DateTime(2013, 06, 02,0,0)))
      println(dt)
  }
}