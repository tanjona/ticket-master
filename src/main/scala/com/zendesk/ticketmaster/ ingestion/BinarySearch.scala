package com.zendesk.ticketmaster.ingestion

import com.zendesk.ticketmaster.model.SearchItem

import scala.annotation.tailrec

object BinarySearch {
  def search(target:String, items:List[SearchItem]) = {
    @tailrec
    def hat(mid:Int, subItems:List[SearchItem]):Option[SearchItem]=  subItems match {
      case elem::Nil if elem.value == target => Some(elem)
      case elem::Nil => None
      case list => {
        val(lows,highs) = list.splitAt(mid)
        if (list(mid).value > target)
          hat((lows.size)/2, lows)
        else
          hat((highs.size)/2, highs)
      }
    }
    hat((items.size)/2, items);
  }
}
