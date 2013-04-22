package data


object Main {
  def main(args: Array[String]) {
//    Parser(args mkString " ") match {
    Parser("(+ 3 4)") match {
      case Parser.Success(p, _) => Evaluator(p)
      case a => println(a)
    }
  }
}