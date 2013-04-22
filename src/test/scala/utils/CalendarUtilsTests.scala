package utils

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.FlatSpec

import scala._

import java.util.Locale._

import utils.CalendarUtils._

class CalendarUtilsTest extends FlatSpec with GeneratorDrivenPropertyChecks {

  "Weekday names" should "be calculated for all integers" in {

    for (i <- 0 to 99)
      assert(getWeekDay(i, GERMAN) != "")

  }

}