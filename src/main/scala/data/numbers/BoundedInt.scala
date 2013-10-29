package data.numbers

class BoundedInt(val range: Range, val int: Int) {
  override def toString() = int.toString
}

object BoundedInt {
  implicit def toInt: BoundedInt ⇒ Int = _.int
}
