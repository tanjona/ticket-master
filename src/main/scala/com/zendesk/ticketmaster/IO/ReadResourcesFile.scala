package com.zendesk.ticketmaster.IO
import scala.io.Source
import org.json4s._
import org.json4s.native.JsonMethods._

class ReadResourcesFile {
  def getResource[T](filePath:String)(implicit m: Manifest[T]): List[T] = {
    implicit val formats = DefaultFormats
    val content = Source.fromResource(filePath).getLines().mkString
    parse(content).extract[List[T]]
  }
}
