package com.zendesk.ticketmaster.ingestion

import com.zendesk.ticketmaster.IO.ReadResourcesFile
import com.zendesk.ticketmaster.model.{Organization, Ticket, User}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class RichModelTest extends AnyFlatSpec with should.Matchers {

  "given 2 Orgz" should "change to words" in {
    val reader = new ReadResourcesFile()
    val org = reader.getResource[Organization]("DATA/organizations.json")
    import RichModel._
    val words1 = org(0).toWords
    val words2 = org(1).toWords
    words1.length should be(15)
    words2.length should be(16)
  }


  "given 2 Users" should "change to words" in {
    val reader = new ReadResourcesFile()
    val users = reader.getResource[User]("DATA/users.json")
    import RichModel._
    val words1 = users(0).toWords
    val words2 = users(1).toWords
    words1.length should be(29)
    words2.length should be(28)
  }

  "given 2 tickets" should "change to words" in {
    val reader = new ReadResourcesFile()
    val tickets = reader.getResource[Ticket]("DATA/tickets.json")
    import RichModel._
    val words1 = tickets(0).toWords
    val words2 = tickets(1).toWords
    words1.length should be(44)
    words2.length should be(36)
  }
}
