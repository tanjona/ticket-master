package com.zendesk.ticketmaster.ingestion

import com.zendesk.ticketmaster.IO.ReadResourcesFile
import com.zendesk.ticketmaster.model.Organization
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class BinarySearchSpec extends AnyFlatSpec with should.Matchers  {

  import RichModel._
  val reader = new ReadResourcesFile()

  val words = reader.getResource[Organization]("DATA/organizations.json").flatMap(_.toWords).sortBy(_.value)


  " search on sorted list of org changed to words" should "be successful" in {
    val result = BinarySearch.search("Roy",words)
    result.isDefined should be (true)
  }

  "search on unknow" should "failed" in {
    val res2 = BinarySearch.search("tanjona",words)
    res2.isDefined should be (false)
  }

}
