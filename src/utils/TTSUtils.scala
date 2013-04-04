package utils

import java.io.ByteArrayInputStream

import javazoom.jl.player.Player
import scalaj.http.Http

class PlayerThread(is: ByteArrayInputStream) extends Thread {
  val device = javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice()
  val player = new Player(is, device)

  override def run() {
    player.play()
  }
}

object TTSUtils {

  def tts(lang: String, word: String): Array[Byte] = Http("http://translate.google.com/translate_tts")
    .param("tl", lang)
    .param("q", word)
    .option(urlConn ⇒ urlConn.addRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0)"))
    .asBytes

  def play(lang: String, word: String) = {
    val audio = tts(lang, word)
    val bais = new ByteArrayInputStream(audio)

    val pt = new PlayerThread(bais)
    pt.start();
    while (!pt.player.isComplete()) {
      try {
        Thread.sleep(10);
      } catch {
        case e ⇒ e.printStackTrace();
      }
    }
  }

  def main(args: Array[String]) {
    play("en", "Ok. This doesn't look too bad.")
    // play("ja", "〜のそばに")

  }

}