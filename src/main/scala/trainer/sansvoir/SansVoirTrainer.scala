package trainer.sansvoir

import scala.Console._
import utils.RandomUtils._
import scala.util.parsing.combinator.Parsers

class Position(i: Int, j: Int)
class Piece(c: Char)
class Board

class Move(piece: Piece, from: Position, to: Position)

trait MoveSeqParser extends Parsers {

  type Elem = Char

  //  def parse(in: String): Seq[Move]

  //"elem" parses exactly one element of the defined "Elem" type.
  //In our case this is a Char, just like our manual Parser.
  //The "|" Combinator is the same as our "or" Combinator
  //so this reads "element 'a' or element 'b' or ..."
  val ab01: Parser[Char] = elem('a') | elem('b') | elem('0') | elem('1')

  val myParser: Parser[List[Char]] = ab01*

  //  def double  :Parser[Position] = (decimalNumber | floatingPointNumber) ^^ {s => new NumberLiteral(s.toDouble)}
}

object SansVoirTrainer extends App {

  val symbols_white = ("rnbqkp" zip "♖♘♗♕♔♙") toMap
  val symbols_black = ("RNBQKP" zip "♜♞♝♚♛♟") toMap

  //val f=symbols_white.toF

  val example_game = "1. e4 e5 2. Nf3 Nc6 3. Bb5 a6 4. Ba4 Nf6 5. O-O Nxe4 6. d4 b5 7. Bb3 d5 8. dxe5 Be6 9. Nbd2 Nc5 10. c3 d4 11. Ng5 dxc3 12. Nxe6 fxe6 13. bxc3 Qd3 14. Nf3 Qxd1 15. Bxd1 Be7 16. Be3 Nd3 17. Bb3 Kf7 18. Rad1 Ndxe5 19. Nxe5 Nxe5 20. Bf4 Nc4 21. Bxc4 bxc4 22. Rd4 Bd6 23. Be3 Rhb8 24. Rxc4 Rb2 25. a4 Ra2 26. g3 Rb8 27. Rd1 Rbb2 28. Rdd4 Rb1 29. Kg2 Rba1 30. Rh4 h6 31. Bc5 e5 32. Ba7 Ke6 33. Rcg4 Be7 34. Rh5 Bf6 35. Rc4 Kd7 36. Bb8 c6 37. Re4 Rxa4 38. c4 Ra5 39. Bxe5 Bxe5 40. Rhxe5 Rxe5 41. Rxe5 Ra4 42. Re4 Ra5 43. h4 h5 44. Rf4"

  val board = "RNBQKBNR" + "P" * 8 + " " * 8 * 4 + "p" * 8 + "rnbqkbpr"
  val rows = board.grouped(8)

  val colLbl = 'a' to 'h'
  val rowLbl = 1 to 8

  def lbl(col: Int, row: Int) = "" + colLbl(col) + rowLbl(row)
  def even = (i: Int) ⇒ i % 2 == 0

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