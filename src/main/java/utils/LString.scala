package utils

class LString(val lang: String, val string: String) {}

class LStringBuilder(val str: String) {
  def en = new LString("en", str)
  def ja = new LString("ja", str)
  def zh = new LString("zh", str)
  def ru = new LString("ru", str)
  def fr = new LString("fr", str)
  def es = new LString("es", str)
  def el = new LString("el", str)
  def ko = new LString("ko", str)
  def hi = new LString("hi", str)
  def it = new LString("it", str)
}

object LStringImplicits {
  implicit def str2lstr: String ⇒ LStringBuilder = str ⇒ new LStringBuilder(str)
  implicit def lstr2str: LString ⇒ LStringBuilder = lstr ⇒ lstr.string
}