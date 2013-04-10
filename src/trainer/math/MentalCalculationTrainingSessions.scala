package trainer.math

import java.lang.Math.pow
import utils.ExecutionUtils.REPL
import utils.RandomUtils.randBetween
import utils.TTSUtils.play
import scala.Console._
import scala.testing.Show
import scala.Function1
import utils.LString
import utils.LStringImplicits._

abstract class OpLabel(val label: String) {
  def apply[T1, T2](args: (T1, T2)): String =
    List(args._1, label, args._2).mkString(" ")
}

case class PlayLabel(val name: LString) extends OpLabel(name.string) {
  def apply[T1, T2](args: (T1, T2)): LString = apply(args)
}
case class SignLabel(val sign: String) extends OpLabel(sign) {
}

class CalculationTrainingsLoop(
  gen: Unit ⇒ (Int, Int),
  op: (Int, Int) ⇒ Int,
  opLblPrint: SignLabel,
  opLblPlay: PlayLabel) {
  // main

  def run() = {

    // domain specific methods

    def gradeAnswer(correct: Int)(answer: Int) = correct == answer

    def taskDescription(params: (Int, Int)) = {
      println(opLblPrint(params))
      play(opLblPlay(params))
    }

    def pause = { readLine; Unit }

    // execution loop

    while (true) {

      // read, eval, prnt

      def read1 = pause // warte auf das nächste generieren
      def eval1 = gen
      def print1 = taskDescription

      val result = eval1(read1);
      val context = print1(result);

      // read, eval, prnt

      val correct = op(result) // TODO hier wird context übergeben

      def read2 = readInt()
      def eval2 = gradeAnswer(correct)_
      def print2 = (a: Any) ⇒ println(a)

      print2(eval2(read2))

      // read, eval, prnt

      def read3 = pause
      def eval3 = identity[Unit]_
      def print3 = (a: Any) ⇒ println(a)

      print3(eval3(read3))

    }
  }

  def main(args: Array[String]) {
    run
  }

}

abstract class MultiplicationTrainingLoop(gen: Unit ⇒ (Int, Int)) extends CalculationTrainingsLoop(gen, op, "*", "times".en)

abstract class DivisionTrainingLoop extends CalculationTrainingsLoop {
  def lang_opname = new LString("en", "divided by")
  def opsign = "/"
  def op(a: Int, b: Int) = a / b
}

abstract class SubtractionTrainingLoop extends CalculationTrainingsLoop {
  def lang_opname = new LString("en", "minus")
  def opsign = "-"
  def op(a: Int, b: Int) = a - b
}

abstract class AdditionTrainingLoop extends CalculationTrainingsLoop {
  def lang_opname = new LString("en", "plus")
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
