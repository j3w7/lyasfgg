package tts

import utils.TTSUtils

object TTSTests extends App {

  TTSUtils.play("zh", "星期六")
  TTSUtils.play("ja", "土曜日")
  TTSUtils.play("ko", "토요일")
  TTSUtils.play("fr", "samedi")
  TTSUtils.play("it", "sabato")
  TTSUtils.play("es", "sábado")
  TTSUtils.play("hi", "शनिवार")
  TTSUtils.play("ru", "суббота")
  TTSUtils.play("el", "Σάββατο")

}