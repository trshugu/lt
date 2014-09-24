@echo off

scalac checklinkmodule.scala && ^
scala -classpath ^
./;^
./checklinkmodule;^
 slc.scala %1

rem scala -classpath ./lib/*.jar tmp.scala
rem sbt run