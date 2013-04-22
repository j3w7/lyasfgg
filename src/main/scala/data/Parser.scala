package data

import util.parsing.combinator.RegexParsers

import java.io.{ File, FileOutputStream, PrintStream }

import me.qmx.jitescript.{ JiteClass, CodeBlock }
import me.qmx.jitescript.util.CodegenUtils.{ p, ci, sig }

import org.objectweb.asm.Opcodes._

object Parser extends RegexParsers {
  def int = regex("""[0-9]+""".r) ^^ { (i: String) ⇒ SInt(i.toInt) }
  def ident = regex("""[A-Za-z+-/\*]+""".r) ^^ SIdent
  def sexp = "(" ~> rep(node) <~ ")" ^^ SExp
  def node: Parser[Node] = int | ident | sexp
  def apply(s: String) = parse(sexp, s)
}

