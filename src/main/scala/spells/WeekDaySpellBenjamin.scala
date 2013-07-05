package spells

import java.lang.Math.abs
import org.joda.time.DateTime
import org.joda.time.LocalDate

class Interval[T] (val from: T, val to: T)(implicit num: Numeric[T]) { 
  import num.{mkNumericOps, mkOrderingOps}

  def mid: Double  = (from.toDouble + to.toDouble)/2.0 
  def union(other: Interval[T]) = new Interval(from min other.from, to max other.to)
}

/**
 *  dd.mm.yyyy = dd.mmhttps://inside.1and1.org/https://inside.1and1.org/.ccee
 *  where cc denotes century, ee denotes year in century
 */
object WeekDaySpellBenjamin {

  def digit(number: Int, i: Int): Int = String.valueOf(number).toCharArray()(i)

  def mv(m: Int): Int = List(
    6, 2, 2,
    5, 0, 3,
    5, 1, 4,
    6, 2, 4)(m - 1)

  type DD = Int
  type MM = Int
  type CC = Int
  type EE = Interval[Int](0,99)

  def cv(cc: CC) = 
    Map(
    16 -> 0, 17 -> 5, 18 -> 3, 19 -> 1,
    20 -> 0, 21 -> 5)(cc)
    //TODO 
    //((16,17,18,19),
    // (20,21,22,23)) -> (0,5,3,1)

  def cvc(y: Int, m: Int) =
    if (new LocalDate(y, m, 1).year.isLeap && (m == 1 || m == 2)) -1 else 0

  def r(ee: Int) = abs(ee / 4) + ee

  def yv(y: Int, m: Int) = cv(y) + cvc(y, m)

  def nameOfDay(d: Int, m: Int, y: Int): Int = {
    val cc = y.toString.substring(0, 2).toInt
    val ee = y.toString.substring(2, 4).toInt
    nameOfDay(d, m, y, cc, ee)
  }

  private def nameOfDay(d: Int, m: Int, y: Int, cc: Int, ee: Int): Int =
    (d + mv(m) + cv(cc) + r(ee) + cvc(y, m)) % 7

}