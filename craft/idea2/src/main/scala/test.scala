import dispatch._
import Defaults._

object test { def main(args: Array[String]): Unit = {

  println("asdf")

  val svc = url("http://api.hostip.info/country.php")
  val country = Http(svc OK as.String)

  val b = country()
  println(b)


  for (c <- country)
    println(c)

  println("end")

}}
