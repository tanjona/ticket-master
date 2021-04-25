package com.zendesk.ticketmaster.model

sealed trait EntityType

object EntityType {

  case object Organization extends EntityType

  case object User extends EntityType

  case object Ticket extends EntityType

}

case class SearchItem(value: String, _id: String, field: String, entity: EntityType)
