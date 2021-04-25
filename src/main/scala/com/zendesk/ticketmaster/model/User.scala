package com.zendesk.ticketmaster.model

case class User(
                  _id: Int,
                  url: String,
                  external_id: String,
                  name: String,
                  alias: Option[String],
                  created_at: String,
                  active: Boolean,
                  verified: Option[Boolean],
                  shared: Boolean,
                  locale: Option[String],
                  timezone: Option[String],
                  last_login_at: String,
                  email: Option[String],
                  phone: String,
                  signature: String,
                  organization_id:Option[Integer],
                  tags: List[String],
                  suspended: Boolean,
                  role: String
)

