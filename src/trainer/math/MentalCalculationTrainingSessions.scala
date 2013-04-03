package trainer.math

import java.lang.Math.pow
import utils.ExecutionUtils.REPL
import utils.RandomUtils.randBetween
import utils.TTSUtils.play
import scala.Console._

abstract class CalculationTrainingsLoop extends REPL[(Int, Int), Int] {

  def gen_a: Int
  def gen_b: Int
  def op(a: Int, b: Int): Int
  def opsign: String
  def opname: (String, String)

  def read: (Int, Int) = {
    val a = gen_a
    val b = gen_b

    println(a + " " + opsign + " " + b)
    println("play")
    play(opname._1, a + opname._2 + b)

    return (a, b)
  }

  def eval(p: (Int, Int)) = op(p._1, p._2)

  def print(i: Int) = {
    readLine
    println(i)
  }

  def init() = {}

  def main(args: Array[String]) {
    init
    run
  }

}

abstract class MultiplicationTrainingLoop extends CalculationTrainingsLoop {
  def opname = ("en", "times")
  def opsign = "*"
  def op(a: Int, b: Int) = a * b
}
abstract class DivisionTrainingLoop extends CalculationTrainingsLoop {
  def opname = ("en", "divided by")
  def opsign = "/"
  def op(a: Int, b: Int) = a / b
}
abstract class SubtractionTrainingLoop extends CalculationTrainingsLoop {
  def opname = ("en", "minus")
  def opsign = "-"
  def op(a: Int, b: Int) = a - b
}
abstract class AdditionTrainingLoop extends CalculationTrainingsLoop {
  def opname = ("en", "plus")
  def opsign = "+"
  def op(a: Int, b: Int) = a + b
}

object Multiplication11Loop extends MultiplicationTrainingLoop {
  def gen_a = randBetween(6, 9)
  def gen_b = randBetween(6, 9)
}

object Multiplication21Loop extends MultiplicationTrainingLoop {
  def gen_a = randBetween(1, 99)
  def gen_b = randBetween(1, 9)
}

object Multiplication31Loop extends MultiplicationTrainingLoop {
  def gen_a = randBetween(1, 999)
  def gen_b = randBetween(1, 9)
}

object Addition33Loop extends AdditionTrainingLoop {
  def gen_a = randBetween(1, 9999)
  def gen_b = randBetween(1, 999)
}

object Addition43Loop extends AdditionTrainingLoop {
  def gen_a = randBetween(1, 9999)
  def gen_b = randBetween(1, 999)
}

object Addition44Loop extends AdditionTrainingLoop {
  def gen_a = randBetween(1, 9999)
  def gen_b = randBetween(1, 9999)
}

object AdditionLoop extends AdditionTrainingLoop {

  var da = 0
  var db = 0

  def gen_a = randBetween(1, da)
  def gen_b = randBetween(1, db)

  override def init = {
    println("a digits: "); da = pow(10, readInt).toInt - 1
    println("b digits: "); db = pow(10, readInt).toInt - 1
  }
}
