package tts

import utils.TTSUtils
import utils.LStringImplicits._

object TTSTests extends App {

  TTSUtils.play("星期六".zh)
  TTSUtils.play("土曜日".ja)
  TTSUtils.play("토요일".ko)
  TTSUtils.play("samedi".fr)
  TTSUtils.play("sabato".it)
  TTSUtils.play("sábado".es)
  TTSUtils.play("शनिवार".hi)
  TTSUtils.play("суббота".ru)
  TTSUtils.play("Σάββατο".el)

}