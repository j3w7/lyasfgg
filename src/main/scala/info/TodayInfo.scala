package info

import java.util.Locale.CHINA
import java.util.Locale.FRANCE
import java.util.Locale.ITALY
import java.util.Locale.JAPAN
import java.util.Locale.KOREA
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import utils.CalendarUtils.getWeekDay
import utils.LocaleUtils.GREECE
import utils.LocaleUtils.INDIA
import utils.LocaleUtils.RUSSIA
import utils.LocaleUtils.SPANISH
import org.joda.time.chrono.ISOChronology
import org.joda.time.DateTimeZone
import org.joda.time.tz.DateTimeZoneBuilder

object TodayInfo extends App {

  val dt = LocalDate.now()
  println(DateTimeFormat.forPattern("dd.MM.yyyy").print(dt))
  print(getWeekDay(dt, CHINA) + "  " +
    getWeekDay(dt, JAPAN) + "  " +
    getWeekDay(dt, KOREA) + "\n" +
    getWeekDay(dt, FRANCE) + "  " +
    getWeekDay(dt, ITALY) + "  " +
    getWeekDay(dt, SPANISH) + "\n" +
    getWeekDay(dt, INDIA) + "  " +
    getWeekDay(dt, RUSSIA) + "  " +
    getWeekDay(dt, GREECE))
}