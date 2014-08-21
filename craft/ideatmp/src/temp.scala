import akka.actor
import akka.actor._
import java.util.concurrent.TimeUnit;


class Act extends Actor {
  //val nanika = scala.util.Random.alphanumeric.take(8).mkString
  val nanika = "a:" + System.currentTimeMillis()
  def actt = {
    println("act:" + nanika)
  }
}


object temp { def main(args: Array[String]): Unit = {
  println("hell world")
  val a = new Act
  a.start

}}