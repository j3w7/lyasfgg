package test

import java.text.SimpleDateFormat
import java.util.Locale.CHINA
import java.util.Locale.JAPAN
import java.util.GregorianCalendar

import utils.CalendarUtils.genDate
import utils.CalendarUtils.getWeekDay
import utils.ExecutionUtils.REPL
import utils.LocaleUtils.INDIA

object DateTrainingsLoop extends App with REPL[GregorianCalendar, String] {

  def init() = {}

  def read: GregorianCalendar = {
    val gc = genDate
    println(new SimpleDateFormat("dd.MM.yyyy").format(gc.getTime()))
    readLine
    return gc
  }

  def eval(gc: GregorianCalendar): String = {
    getWeekDay(gc, CHINA) + " " + getWeekDay(gc, JAPAN) + " " + getWeekDay(gc, INDIA)
  }

  def print(s: String) = println(s +"\n")

  init
  run

}

