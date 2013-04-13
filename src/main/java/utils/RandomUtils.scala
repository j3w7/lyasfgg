package utils

import java.lang.Math._

object RandomUtils {

  def randBetween(start: Int, end: Int): Int =
    start + round(random * (end - start)).toInt

    
  def randOfLen(n: Int) = randBetween(0, pow(10, n).toInt - 1)

}