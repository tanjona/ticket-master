
ThisBuild / scalaVersion := "2.13.5"
ThisBuild / organization := "com.zendesk"

lazy val main = (project in file("."))
  .settings(
    version := "0.1",
      name := "Ticket-master",
    libraryDependencies ++= Seq(
      "org.rogach" %% "scallop" % "4.0.2",
      "org.json4s" %% "json4s-native" % "3.7.0-M16",
      "com.github.nikita-volkov" % "sext" % "0.2.4",
      "org.scalactic" %% "scalactic" % "3.2.7",
      "org.scalatest" %% "scalatest" % "3.2.7",
      "com.github.nikita-volkov" % "sext" % "0.2.4"
    )
  )