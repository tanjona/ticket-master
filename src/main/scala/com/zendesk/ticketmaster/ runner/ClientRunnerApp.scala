package com.zendesk.ticketmaster.runner

import com.zendesk.ticketmaster.excutor.CommandExecutor
import com.zendesk.ticketmaster.ingestion.FilesReader

import scala.io.StdIn
import scala.util.Try
import scala.util.control.Breaks._

object ClientRunnerApp {
  def main(args: Array[String]): Unit = {
    val orgz = FilesReader.organizations
    var line = ""
    println(
      """
        |Welcome to Zendesk Search
        |Type '--help' to get all the command availabe
        |Type 'quit' to exit
        |""".stripMargin)
    print("> ")
    import sext._

    breakable {
      while ( {
        line = StdIn.readLine();
        line != null
      }) {

        if (line.compareToIgnoreCase("quit") == 0)
          break

       Try {
         val args = new Conf(line.split("[\\s]+").toVector)
         val exec = new CommandExecutor(args.pattern(), args.entity.toOption, args.field.toOption)
         val result =exec.run

         if (result.isEmpty)
           println("No match found")
         else
           println(result.get.treeString)
       }
        print("> ")
      }
    }

  }
}
