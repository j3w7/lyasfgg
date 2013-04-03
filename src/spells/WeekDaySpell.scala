package test

import java.util.Date
import java.lang.Math.abs

object WeekDaySpell extends App {

  def digit(number: Int, i: Int): Int = String.valueOf(number).toCharArray()(i)

  def mv(m: Int): Int = List(
    0, 3, 3,
    6, 1, 4,
    6, 2, 5,
    0, 3, 5)(m - 1)

  def cv(y: Int) = Map(
    16 -> 0,
    17 -> 5,
    18 -> 3,
    19 -> 1,
    20 -> 0).get(abs(y / 100))

  def nameOfDay(d: Int, m: Int, y: Int): Int = {
    val r = (digit(y, 2) * 10 + digit(y, 3))

    //FIXME   return (d + mv(m) + r + cv(y) + (r % 28) + abs(r / 4)) % 7
    return -1
  }

}