package linux

import java.io.File
import java.net.URL

import scala.sys.process.urlToProcess
object DownloadJapanesePod extends App {

  for (i ← 0 to 170) {
    val url = s"http://www.japanesepod101.com/pdfs/${"%03d" format (2 + i)}_B${1 + i}_${1219 + i}05_jpod101.pdf"
    val file = url.substring(url.lastIndexOf('/')+1)

    new URL(url) #> new File(file) !
  }

}
