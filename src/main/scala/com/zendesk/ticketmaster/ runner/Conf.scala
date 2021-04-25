package com.zendesk.ticketmaster. runner

import org.rogach.scallop.ScallopConf
import org.rogach.scallop.exceptions.ScallopException

class Conf(arguments: Seq[String]) extends ScallopConf(arguments) {

  def validateEntity(input:String) = input == "user" || input == "ticket" || input == "organizations"
  val pattern = opt[String](required = true, argName = "pattern",descr = "The word look up" , short = 'p')
  val entity = opt[String](required = false,descr = "specific Entity[user|ticket|organizations] ", validate = validateEntity, short = 'e')
  val field = opt[String](required = false,descr = "specific field ticket",  short = 'f')

  override def onError(e: Throwable) = e match {
    case ScallopException(message) =>
      println(message)
      printHelp
    case ex => super.onError(ex)
  }

  verify()
}