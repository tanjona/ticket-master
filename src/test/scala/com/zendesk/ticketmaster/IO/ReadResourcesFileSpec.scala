package com.zendesk.ticketmaster.IO
import com.sun.imageio.plugins.jpeg.JPEGImageReaderResources
import com.zendesk.ticketmaster.model.Organization
import org.scalatest._
import flatspec._
import matchers._

class ReadResourcesFileSpec extends AnyFlatSpec with should.Matchers  {
  "An organisation json file"  should  "be correctly parsed to case class" in {
      val reader = new ReadResourcesFile()
      val org = reader.getResource[Organization]("DATA/organizations.json")
     org.length should be (25)
  }

}
