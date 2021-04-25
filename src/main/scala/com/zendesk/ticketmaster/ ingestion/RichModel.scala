package com.zendesk.ticketmaster.ingestion

import com.zendesk.ticketmaster.model.{EntityType, Organization, SearchItem, Ticket, User}

object RichModel {
  def stringToWords(input: String) = input.split("[\\s@&.?$+-]+").toList

  implicit class OrgToWords(org: Organization) {
    val id = org._id.toString;

    def toWords: List[SearchItem] = List(
      List(SearchItem(org._id.toString, id, "_id", EntityType.Organization)),
      List(SearchItem(org.url, id, "url", EntityType.Organization)),
      List(SearchItem(org.external_id, id, "external_id", EntityType.Organization)),
      List(SearchItem(org.created_at, id, "created_at", EntityType.Organization)),
      stringToWords(org.name).map(word => SearchItem(word, id, "name", EntityType.Organization)),
      stringToWords(org.details).map(word => SearchItem(word, id, "details", EntityType.Organization)),
      List(SearchItem(org.shared_tickets.toString, id, "shared_tickets", EntityType.Organization)),
      org.domain_names.map(word => SearchItem(word, id, "domain_names", EntityType.Organization)),
      org.tags.flatMap(tag => stringToWords(tag).map( word => SearchItem(word, id, "tags", EntityType.Organization)))
    ).flatten
  }

  implicit class UserToWords(user: User) {
    val id = user._id.toString;

    def toWords: List[SearchItem] = List(
      List(SearchItem(user._id.toString, id, "_id", EntityType.User)),
      List(SearchItem(user.url, id, "url", EntityType.User)),
      List(SearchItem(user.external_id, id, "external_id", EntityType.User)),
      stringToWords(user.name).map(word => SearchItem(word, id, "name", EntityType.User)),
      stringToWords(user.alias.getOrElse("")).map(word => SearchItem(word, id, "alias", EntityType.User)),
      List(SearchItem(user.created_at, id, "created_at", EntityType.User)),
      List(SearchItem(user.active.toString, id, "active", EntityType.User)),
      List(SearchItem(user.verified.map(_.toString).getOrElse(""), id, "verified", EntityType.User)),
      List(SearchItem(user.shared.toString, id, "shared", EntityType.User)),
      List(SearchItem(user.locale.getOrElse(""), id, "locale", EntityType.User)),
      List(SearchItem(user.locale.getOrElse(""), id, "locale", EntityType.User)),
      stringToWords(user.timezone.getOrElse("")).map(word => SearchItem(word, id, "timezone", EntityType.User)),
      stringToWords(user.signature).map(word => SearchItem(word, id, "signature", EntityType.User)),
      List(SearchItem(user.last_login_at, id, "last_login_at", EntityType.User)),
      stringToWords(user.email.getOrElse("")).map(word => SearchItem(word, id, "email", EntityType.User)),
      user.tags.flatMap(tag => stringToWords(tag).map( word => SearchItem(word, id, "tags", EntityType.User))),
      List(SearchItem(user.suspended.toString, id, "suspended", EntityType.User)),
      List(SearchItem(user.role, id, "role", EntityType.User))
    ).flatten
  }

  implicit class TicketToWords(ticket: Ticket) {
    val id = ticket._id;

    def toWords: List[SearchItem] = List(
      List(SearchItem(ticket._id, id, "_id", EntityType.Ticket)),
      List(SearchItem(ticket.url, id, "url", EntityType.Ticket)),
      List(SearchItem(ticket.external_id, id, "external_id", EntityType.Ticket)),
      List(SearchItem(ticket.created_at, id, "created_at", EntityType.Ticket)),
      List(SearchItem(ticket.`type`.getOrElse(""), id, "type", EntityType.Ticket)),
      stringToWords(ticket.description.getOrElse("")).map(word => SearchItem(word, id, "description", EntityType.Ticket)),
      stringToWords(ticket.subject).map(word => SearchItem(word, id, "subject", EntityType.Ticket)),
      List(SearchItem(ticket.priority, id, "priority", EntityType.Ticket)),
      List(SearchItem(ticket.status, id, "status", EntityType.Ticket)),
      ticket.tags.flatMap(tag => stringToWords(tag).map( word => SearchItem(word, id, "tags", EntityType.Ticket))),
      List(SearchItem(ticket.due_at.getOrElse(""), id, "due_at", EntityType.Ticket)),
      List(SearchItem(ticket.via.getOrElse(""), id, "via", EntityType.Ticket)),
    ).flatten
  }

}
