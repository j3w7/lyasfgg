package spells

import junit.framework.Test
import org.scalatest.FlatSpec
import org.scalatest.PropSpec
import org.joda.time.DateTime
import org.scalatest.prop.GeneratorDrivenPropertyChecks
  import org.scala_tools.time.Imports._

class WeekDaySpellTest extends FlatSpec with GeneratorDrivenPropertyChecks {

  "A weekday" should "be calculated correctly" in {

    val yyyy = 1978
    val mm = 4
    val dd = 7

    var weekday = new DateTime(yyyy, mm, dd, 0, 0).getDayOfWeek % 7
    val weekdayMental = WeekDaySpellBenjamin.nameOfDay(7, 4, 2013)
    assert(weekdayMental === weekday)

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