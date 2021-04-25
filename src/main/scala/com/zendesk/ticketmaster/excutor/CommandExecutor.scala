package com.zendesk.ticketmaster.excutor

import com.zendesk.ticketmaster.ingestion.FilesReader
import com.zendesk.ticketmaster.ingestion.BinarySearch

class CommandExecutor(pattern: String, entity: Option[String], field: Option[String]) {

  import com.zendesk.ticketmaster.ingestion.RichModel._

  lazy val userWords = FilesReader.users.flatMap(_.toWords)
  lazy val orgWords = FilesReader.organizations.flatMap(_.toWords)
  lazy val ticketsWords = FilesReader.tickets.flatMap(_.toWords)

  def run = {
    val words = entity.map(e => e match {
      case "user" => userWords
      case "ticket" => ticketsWords
      case "organization" => orgWords
      case _ => userWords ++ orgWords ++ ticketsWords

    }).getOrElse(userWords ++ orgWords ++ ticketsWords)
    BinarySearch.search(pattern, field.map(f => words.filter(w => w.field == f )).getOrElse(words))
  }

}
