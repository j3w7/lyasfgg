package utils

object ExceptionUtils {

  def optNFE[T](t: => T) = try { Some(t) } catch { case nfe: NumberFormatException => None }

}