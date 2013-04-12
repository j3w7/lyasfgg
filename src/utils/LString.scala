package utils

class LString(val lang: String, val string: String) {}

class LStringBuilder(val str: String) {
  def en = new LString("en", str)
  def ja = new LString("ja", str)
}

object LStringImplicits {
  implicit def str2lstr: String ⇒ LStringBuilder = str ⇒ new LStringBuilder(str)
  implicit def lstr2str: LString ⇒ LStringBuilder = lstr ⇒ lstr.string
}