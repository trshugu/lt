/*
*/
// sbt actor
import akka.actor
import akka.actor._

class act extends Actor {
  def receive = {case x =>
    println("act:" + x)
  }
}



object tmp { def main(args: Array[String]): Unit = {
  println("start")

  val as = ActorSystem.create
  val ref = as.actorOf( Props(new act()) )
  ref ! "rec"
  as.shutdown()

  println("end")
}}
