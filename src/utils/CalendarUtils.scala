package utils

import java.util.Calendar._
import java.util.GregorianCalendar
import utils.RandomUtils.randBetween
import java.util.Locale
import java.text.DateFormatSymbols

object CalendarUtils {

  def genDate = {
    val year = randBetween(1600, 2010)
    val month = randBetween(0, 11)
    val gc = new GregorianCalendar(year, month, 1)
    val day = randBetween(1, gc.getActualMaximum(DAY_OF_MONTH))

    gc.set(year, month, day)
    gc
  }

  def getWeekDay(gc: GregorianCalendar, l: Locale): String = new DateFormatSymbols(l).getWeekdays()(gc.get(DAY_OF_WEEK))

}