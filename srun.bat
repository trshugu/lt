@echo off

scala -classpath ^
./;^
:./lib/dispatch-core_2.10-0.11.1.jar;^
:./lib/jedis-2.4.1.jar;^
:./lib/json4s-core_2.9.3-3.2.10.jar;^
:./lib/json4s-native_2.9.3-3.2.10.jar;^
:./lib/jyaml-1.3.jar;^
:./lib/paranamer-2.5.6.jar;^
:./lib/snakeyaml-1.13.jar;^
:./lib/yamlbeans-1.0.jar;^
./lib/gson-2.2.4.jar;^
:./lib/slf4j-simple-1.7.2.jar;^
:./lib/slf4j-api-1.7.2.jar;^
:./lib/log4j.properties;^
:./lib/logback.properties;^
:./lib/logback.xml;^
:./lib/logback-core-1.1.2.jar;^
:./lib/logback-classic-1.1.2.jar;^
:./lib/logback-access-1.1.2.jar;^
./lib/scalatra_2.11-2.3.0.jar;^
./lib/javax.servlet_3.0.0.v201112011016.jar;^
 tmp.scala %1

rem scala -classpath ./lib/*.jar tmp.scala
rem sbt run