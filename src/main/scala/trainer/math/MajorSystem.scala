package trainer.math

/**
 * cf. <a href="http://en.wikipedia.org/wiki/Mnemonic_major_system">major system</a>
 */
object MajorSystem {
  //0 	/s/ /z/ 	s, z, soft c 	"z" is the first letter of zero. The other letters have a similar sound.

  //1 	/t/ /d/ 	t, d 	t & d have one downstroke and sound similar (some variant systems include "th")

  //2 	/n/ 	n 	n has two downstrokes

  //3 	/m/ 	m 	M has three downstrokes and looks like a "3" on its side

  //4 	/r/ 	r 	last letter of four, also 4 and R are almost mirror images of each other

  //5 	/l/ 	l 	L is the Roman Numeral for 50

  //6 	/ʃ/ /ʒ/ /tʃ/ /dʒ/ 	she, vision, chew, gee 	a script j has a lower loop / g is almost a 6 rotated

  //7 	/k/ /ɡ/ 	k, hard c, hard g, hard "ch", q, qu 	capital K "contains" two sevens (some variant systems include "ng")

  //8 	/f/ /v/ 	f, v 	script f resembles a figure-8. V sounds similar.

  //9 	/p/ /b/ 	p, b 	p is a mirror-image 9. b sounds similar and resembles a 9 rolled around

  //Unassigned 		Vowel sounds, w,h,y,x 	These can be used anywhere without changing a word's number value

  def encode = Map[Char, List[String]](
    '0' -> List("s", "z"),
    '1' -> List("t", "d"),
    '2' -> List("n"),
    '3' -> List("m"),
    '4' -> List("r"),
    '5' -> List("l"),
    '6' -> List("j", "sh", "sch"),
    '7' -> List("k", "g"),
    '8' -> List("f", "v"),
    '9' -> List("p", "b")
  )

}

