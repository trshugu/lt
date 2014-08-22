name := "tmp"

version := "0.0"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
  "org.scalatra" %% "scalatra" % "2.3.0",
  "org.slf4j" % "slf4j-log4j12" % "1.7.7",
  //"org.json4s" %% "json4s-native" % "3.2.10",
  "org.json4s" %% "json4s-jackson" % "3.2.10"
)


