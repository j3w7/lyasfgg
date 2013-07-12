package spells

import java.lang.Math.abs
import org.joda.time.DateTime
import org.joda.time.LocalDate

class Interval[T](val from: T, val to: T)(implicit num: Numeric[T]) {
  import num.{ mkNumericOps, mkOrderingOps }

  def mid: Double = (from.toDouble + to.toDouble) / 2.0
  def union(other: Interval[T]) = new Interval(from min other.from, to max other.to)
}

class BoundedInt(val range: Range, val int: Int) {
}

object BoundedInt {
  implicit def toInt: BoundedInt ⇒ Int = _.int
}

class DD(i: Int) extends BoundedInt(1 until 31, i)
class MM(i: Int) extends BoundedInt(1 until 12, i)
class CC(i: Int) extends BoundedInt(0 until 99, i)
class EE(i: Int) extends BoundedInt(0 until 9, i)
class YYYY(y: Int) extends BoundedInt(1500 until 2500, y)

/**
  *  dd.mm.yyyy = dd.mmhttps://inside.1and1.org/https://inside.1and1.org/.ccee
  *  where cc denotes century, ee denotes year in century
  */
object WeekDaySpellBenjamin {
  import BoundedInt._

  def mv(m: MM): Int = List(
    6, 2, 2,
    5, 0, 3,
    5, 1, 4,
    6, 2, 4)(m - 1)

  val range_ = (0 until 31)

  implicit def toCC: YYYY ⇒ CC = y ⇒ new CC(y.toString.substring(0, 2).toInt)
  implicit def toEE: YYYY ⇒ EE = y ⇒ new EE(y.toString.substring(2, 4).toInt)

  def cv(cc: CC) =
    Map(
      16 -> 0, 17 -> 5, 18 -> 3, 19 -> 1,
      20 -> 0, 21 -> 5)(cc)

  def cvc(y: YYYY, m: MM) =
    if (new LocalDate(y, m, 1).year.isLeap && (m == 1 || m == 2)) -1 else 0

  def r(ee: EE) = abs(ee / 4) + ee

  def yv(y: YYYY, m: MM) = cv(y) + cvc(y, m)

  // TODO remove . int
  private def nameOfDay(d: DD, m: MM, y: YYYY): Int =
    (d + mv(m) + cv(y) + r(y) + cvc(y, m)) % 7

}
