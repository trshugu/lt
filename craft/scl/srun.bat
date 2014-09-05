@echo off

scalac checklinkmodule.scala && ^
scala -classpath ^
./;^
 slc.scala %1

rem scala -classpath ./lib/*.jar tmp.scala
rem sbt run