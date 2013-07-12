package trainer.math

object MajorSystemTest {

  val options = "4907832378" map (MajorSystem.encode)
                                                  //> options  : scala.collection.immutable.IndexedSeq[List[String]] = Vector(List
                                                  //| (r), List(p, b), List(s, z), List(k, g), List(f, v), List(m), List(n), List(
                                                  //| m), List(k, g), List(f, v))

  val r = "bt" mkString ".*" r                    //> r  : scala.util.matching.Regex = b.*t

  val dict = List("bad", "batman", "bait")        //> dict  : List[String] = List(bad, batman, bait)

  val matches = dict flatMap (r findFirstIn _)    //> matches  : List[String] = List(bat, bait)


}