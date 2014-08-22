@echo off

scalac -classpath ^
:./lib/dispatch-core_2.10-0.11.1.jar;^
:./lib/jedis-2.4.1.jar;^
./lib/json4s-core_2.9.3-3.2.10.jar;^
./lib/json4s-native_2.9.3-3.2.10.jar;^
:./lib/jyaml-1.3.jar;^
./lib/paranamer-2.5.6.jar;^
:./lib/snakeyaml-1.13.jar;^
:./lib/yamlbeans-1.0.jar;^
 tmp.scala %1 && scala tmp
rem sbt run