package com.zendesk.ticketmaster. ingestion

import com.zendesk.ticketmaster.IO.ReadResourcesFile
import com.zendesk.ticketmaster.model.{Organization, Ticket, User}

object FilesReader extends  ReadResourcesFile{
  lazy val organizations: List[Organization] = getResource[Organization]("DATA/organizations.json")
  lazy val users: List[User]  = getResource[User]("DATA/users.json")
  lazy val tickets: List[Ticket] = getResource[Ticket]("DATA/tickets.json")



}
