package data

import java.io.{ File, FileOutputStream, PrintStream }

import me.qmx.jitescript.{ JiteClass, CodeBlock }
import me.qmx.jitescript.util.CodegenUtils.{ p, ci, sig }

import org.objectweb.asm.Opcodes._

sealed trait Node
case class SExp(l: List[Node]) extends Node
case class SInt(i: Int) extends Node
case class SIdent(s: String) extends Node
