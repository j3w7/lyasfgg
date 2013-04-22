package trainer.math

import java.lang.Math.pow

import scala.Console.println
import scala.Console.readBoolean
import scala.Console.readChar
import scala.Console.readLine

import utils.ConsoleUtils.readIntOpt
import utils.RandomUtils.randBetween
import utils.TTSUtils.play

import utils.LStringImplicits._

object MathTrainer {

  def loop(
    gen: (Unit ⇒ (Int, Int)),
    f: (Int, Int) ⇒ Int,
    lbl: String, plbl: String, useSound: Boolean) = {

    while (true) {

      val (a, b) = gen()

      println(List(a, lbl, b).mkString(" "))
      if (useSound) play(List(a, plbl, b).mkString(" ").en)

      println("your result:")
      val result = f(a, b)
      val resultMe = readIntOpt

      val msg = if (result == resultMe.getOrElse(null)) "nice!" else "no, it's " + result
      println(msg)
      if (useSound) play(msg.en)

      println("any key to continue")
      readLine
    }
  }

  def main(args: Array[String]) {

    println("sound?")
    val useSound = readBoolean()

    println("operation:")

    val (f, lbl, plbl) = readChar() match {
      case '+' ⇒ ({ (a: Int, b: Int) ⇒ a + b }, "+", "plus")
      case '-' ⇒ ({ (a: Int, b: Int) ⇒ a - b }, "-", "minus")
      case '*' ⇒ ({ (a: Int, b: Int) ⇒ a * b }, "*", "times")
      case '/' ⇒ ({ (a: Int, b: Int) ⇒ a / b }, "/", "diveded by")
      case '%' ⇒ ({ (a: Int, b: Int) ⇒ a % b }, "%", "modulo")
    }

    println("a digits: "); val da = pow(10, readInt).toInt - 1
    println("b digits: "); val db = pow(10, readInt).toInt - 1

    def gen = { _: Unit ⇒ (randBetween(1, da), randBetween(1, db)) }
    loop(gen, f, lbl, plbl, useSound)
  }

}
