package trainer.sansvoir

import scala.Console._

import utils.RandomUtils._
object SansVoirTrainer extends App {

//♖♘♗♕♔♙
//♜♞♝♚♛♟
  //      'p', 'R', 'p', 'B', 'Q', 'K', 'B', 'p', 'R'

  val board =
    (
      ('R', 'p', 'B', 'Q', 'K', 'B', 'p', 'R'),
      ('p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'),
      (' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
      (' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
      (' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
      (' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
      (' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
      (' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '),
      ('p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'),
      ('R', 'p', 'B', 'Q', 'K', 'B', 'p', 'R')
    )

  val colLbl = 'a' to 'h'
  val rowLbl = 1 to 8

  def lbl(col: Int, row: Int) = "" + colLbl(col) + rowLbl(row)
  def even = (i: Int) ⇒ i % 2 == 0

  //      'p', 'R', 'p', 'B', 'Q', 'K', 'B', 'p', 'R'

  //  type Square = (Int, Int, Piece)

  //  val square(l: Int, n: Int)

  while (true) {
    val col = randBetween(0, 7)
    val row = randBetween(0, 7)

    print(lbl(col, row))
    readLine()

    val color = if (even(col + row)) "black" else "white"

    println(color)
    println
  }

}