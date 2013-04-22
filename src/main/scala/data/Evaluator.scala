package data

import util.parsing.combinator.RegexParsers

import java.io.{ File, FileOutputStream, PrintStream }

import me.qmx.jitescript.{ JiteClass, CodeBlock }
import me.qmx.jitescript.util.CodegenUtils.{ p, ci, sig }

import org.objectweb.asm.Opcodes._

object Evaluator {
  def compile(b: CodeBlock, n: Node) {
    n match {
      case SExp(Nil) ⇒ {}
      case SExp(x :: xs) ⇒ {
        xs.foreach(compile(b, _))
        compile(b, x)
      }
      case SInt(x)     ⇒ b.pushInt(x)
      case SIdent("+") ⇒ b.iadd()
      case SIdent("-") ⇒ b.isub()
      case SIdent("*") ⇒ b.imul()
      case SIdent("/") ⇒ b.idiv()
    }
  }

  def apply(program: SExp) {
    val b = new CodeBlock
    compile(b, program)
    b.iprintln().voidreturn()

    val name = "Lisp"
    val c = new JiteClass(name)
    c.defineMethod("main", ACC_PUBLIC | ACC_STATIC, sig(classOf[Unit], classOf[Array[String]]), b)

    val stream = new FileOutputStream(new File(name + ".class"))
    stream.write(c.toBytes)
    stream.close()
  }
}
