package spells

import org.joda.time.DateTime
import org.scalatest.FlatSpec
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import utils.CalendarUtils.daysFromTo
import org.joda.time.MutableDateTime
import org.joda.time.DateTimeZone
import org.joda.time.LocalDate

class WeekDaySpellTest extends FlatSpec with GeneratorDrivenPropertyChecks {

  "A weekday" should "be calculated correctly" in {

    for (
      dt ← daysFromTo(
        new LocalDate(1600, 1, 1),
        new LocalDate(2199, 12, 31))
    ) {

      var weekday = dt.getDayOfWeek % 7

      val weekdayMental = WeekDaySpellBenjamin.nameOfDay(
        new DD(dt.dayOfMonth().get()),
        new MM(dt.monthOfYear().get()),
        new YYYY(dt.year().get()))
      println(dt)
      assert(weekdayMental === weekday)

    }

  }
  /*
  forAll { (y: Int, m: Int, d:Int) =>
    var dt = new DateTime(y,m,d,0,0)
    whenever(dt) {
      val f = new Fraction(n, d)
      f.denom should be > 0 
    }
  }*/
}