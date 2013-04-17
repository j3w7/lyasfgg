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
import trainer.math.CalculationTrainingsLoop._

abstract class OpLabel(val label: String) {
  def label[T1, T2](args: (T1, T2)): String =
    List(args._1, label, args._2).mkString(" ")
}

case class PlayLabel(val name: LString) extends OpLabel(name.string) {
  def llabel[T1, T2](args: (T1, T2)): LString = new LString(name.lang, label(args))
}

case class SignLabel(val sign: String) extends OpLabel(sign)

object CalculationTrainingsLoop {

  implicit def playLabel: LString ⇒ PlayLabel = new PlayLabel(_)
  implicit def signLabel: String ⇒ SignLabel = new SignLabel(_)

  implicit def toLString: PlayLabel ⇒ LString = lbl ⇒ lbl.name

  def gen2(range1: (Int, Int), range2: (Int, Int)): (Unit ⇒ (Int, Int)) =
    { _ ⇒ (randBetween(range1._1, range1._2), randBetween(range2._1, range2._2)) }

  def optNFE[T](t: ⇒ T) = try { Some(t) } catch { case nfe: NumberFormatException ⇒ None }

  def myReadInt = optNFE(readInt)
}

class CalculationTrainingsLoop(
  gen: Unit ⇒ (Int, Int),
  op: (Int, Int) ⇒ Int,
  printLabel: SignLabel,
  playLabel: PlayLabel) {
  // main

  def run() = {

    // domain specific methods

    def gradeAnswer(correct: Int)(answer: Int) = correct == answer

    println("sound? ")
    val sound = readBoolean()

    def taskDescription(params: (Int, Int)) = {
      println(printLabel.label(params))
      if (sound)
        play(playLabel.llabel(params))
    }

    def pause = { readLine; Unit }

    // execution loop

    while (true) {

      // myRead, eval, prnt

      def myRead1 = Unit // warte auf das nächste generieren
      def eval1 = gen
      def print1 = taskDescription(_)

      val result: (Int, Int) = eval1(myRead1);
      val context = print1(result);

      // myRead, eval, prnt

      val correct = op(result._1, result._2) // TODO hier wird context übergeben; TODO hier gibt's Typ Probleme

      def myRead2 = myReadInt // TODO capture NumberFormatException if no or malformed input
      def eval2 = (i: Int) ⇒ {
        if (gradeAnswer(correct)(i)) "ok" else "wrong, should be " + correct
      }
      def print2 = (msg: String) ⇒ {
        println(msg);
        if (sound) play(msg.en)
      }

      print2(eval2(myRead2.getOrElse(-1)))

      // pause-repl 

      readLine()
    }
  }

  def main(args: Array[String]) {
    run
  }

}

class MultiplicationTrainingLoop(gen: Unit ⇒ (Int, Int))
  extends CalculationTrainingsLoop(gen, { _ * _ }, "*", "times".en)

class DivisionTrainingLoop(gen: Unit ⇒ (Int, Int))
  extends CalculationTrainingsLoop(gen, { _ / _ }, "/", "divided by".en)

class SubtractionTrainingLoop(gen: Unit ⇒ (Int, Int))
  extends CalculationTrainingsLoop(gen, { _ - _ }, "-", "minus".en)

class AdditionTrainingLoop(gen: Unit ⇒ (Int, Int))
  extends CalculationTrainingsLoop(gen, { _ + _ }, "+", "plus".en)

object Multiplication11Loop extends MultiplicationTrainingLoop(gen2((6, 9), (6, 9)))
object Multiplication21Loop extends MultiplicationTrainingLoop(gen2((1, 99), (1, 9)))
object Multiplication31Loop extends MultiplicationTrainingLoop(gen2((1, 999), (1, 9)))
object Addition33Loop extends AdditionTrainingLoop(gen2((1, 999), (1, 999)))
object Addition43Loop extends AdditionTrainingLoop(gen2((1, 9999), (1, 999)))
object Addition44Loop extends AdditionTrainingLoop(gen2((1, 9999), (1, 9999)))

object AdditionLoop {
  def main(args: Array[String]) {
    println("a digits: "); val da = pow(10, (myReadInt.getOrElse(10)).toDouble).toInt - 1
    println("b digits: "); val db = pow(10, (myReadInt.getOrElse(10)).toDouble).toInt - 1

    new AdditionTrainingLoop(gen2((1, da), (1, db))).run()
  }
}

object MultiplicationLoop {
  def main(args: Array[String]) {
    println("a digits: "); val da = pow(10, (myReadInt.getOrElse(10)).toDouble).toInt - 1
    println("b digits: "); val db = pow(10, (myReadInt.getOrElse(10)).toDouble).toInt - 1

    new MultiplicationTrainingLoop(gen2((1, da), (1, db))).run()
  }
}

// TODO Kettenaufgaben: 1. gen + gen  if falsch von vorne else trainiere result + gen ... usw ...; Evtl. auch mit variation der operatoren und zahlengrößen

