package spells

import java.lang.Math.abs
import org.joda.time.DateTime
import org.joda.time.LocalDate

object WeekDaySpellBenjamin {

  def digit(number: Int, i: Int): Int = String.valueOf(number).toCharArray()(i)

  def mv(m: Int): Int = List(
    6, 2, 2,
    5, 0, 3,
    5, 1, 4,
    6, 2, 4)(m - 1)

  def cv(y: Int) = Map(
    16 -> 0, 17 -> 5, 18 -> 3, 19 -> 1,
    20 -> 0, 21 -> 5)(y)

  // TODO check why this is not working as (cvsc2)
  def cvc(cc: Int, m: Int) =
    if (((cc % 4) == 0) && (m == 1 || m == 2)) -1 else 0

  def cvc2(y: Int, m: Int) =
    if (new LocalDate(y, m, 1).year().isLeap() && (m == 1 || m == 2)) -1 else 0

  def r(dy: Int) = abs(dy / 4) + dy

  def nameOfDay(d: Int, m: Int, y: Int): Int = {
    val cc = y.toString.substring(0, 2).toInt
    val dy = y.toString.substring(2, 4).toInt

    //cvc(cc, m)
    return (d + mv(m) + cv(cc) + cvc2(y, m) + r(dy)) % 7
  }

}