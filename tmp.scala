/*
object tmp { def main(args: Array[String]): Unit = {
}}
*/


/*
// 並行処理 checker2
import akka.actor
import akka.actor._
import java.util.concurrent.TimeUnit

class master extends Actor {
  var task = 0
  var done = 0
  
  def receive = {
    case "uri" =>
      (1 to 100).foreach {i=>
        val s = as.actorOf( Props(new slave()) )
        task += 1
        s ! i
      }
    case "check" =>
      println("task:" + task)
      println("done:" + done)
      if (done>=task){
        println("shutdown")
        as.shutdown
      }
    case "plus" =>
      done += 1
  }
}

class slave extends Actor {
  def receive = {
    case x: Integer =>
      if (x % 10000 == 0){
        //println(x)
      }
      //println("nanigasikanosyori")
      sender ! "plus"
      //TimeUnit.MILLISECONDS.sleep(1000)
  }
}

val as = ActorSystem.create
val m = as.actorOf( Props(new master()) )
m ! "uri"
//as.shutdown
while(as.isTerminated == false){
  println("check")
  m ! "check"
  TimeUnit.MILLISECONDS.sleep(2000)
}
*/



/*
// 並行処理 checker
import akka.actor
import akka.actor._
import java.util.concurrent.TimeUnit

class master extends Actor {
  def receive = {
    case x =>
      val s = as.actorOf( Props(new slave()) )
      s ! "plu"
  }
}

class slave extends Actor {
  def receive = {
    case x =>
      c ! "plus"
      c ! "plus"
      c ! "plus"
      c ! "plus"
      c ! "plus"
      c ! "plus"
  }
}

class checker extends Actor {
  var cnt = 0
  def receive = {
    case "check" =>
      if (cnt>5)
        println("shutdown")
        as.shutdown
    case "plus" =>
      cnt += 1
  }
}

val as = ActorSystem.create
val m = as.actorOf( Props(new master()) )
val c = as.actorOf( Props(new checker()) )
m ! "uri"
//as.shutdown
while(as.isTerminated == false){
  println("check")
  c ! "check"
  TimeUnit.MILLISECONDS.sleep(1000)
}
*/


/*
// 並行処理 Master/Slave2
import akka.actor
import akka.actor._
import java.util.concurrent.TimeUnit

class master extends Actor {
  def receive = {
    case x =>
      (0 to 2).foreach{i=>
        t ! "plus"
        val s = as.actorOf( Props(new slave()) )
        s ! "mimi"
      }
      
      
  }
}

class slave extends Actor {
  def receive = {case x =>
    t ! "minus"
  }
}

class term extends Actor {
  var cnt = 0
  def receive = {
    case "plus" =>
      cnt = cnt + 1
      println("plus:" + cnt)
    case "minus" =>
      cnt = cnt - 1
      println("minus:" + cnt)
    case "get" =>
      println("get:" + cnt)
  }
}

val as = ActorSystem.create
val m = as.actorOf( Props(new master()) )
val t = as.actorOf( Props(new term()) )
m ! "uri"
//as.shutdown
*/



/**
// 自分自身へのメッセージ送信
import akka.actor
import akka.actor._
import java.util.concurrent.TimeUnit

class a extends Actor {
  def receive = {
    case "ichi" =>
      println("1s")
      a ! "ni"
      println("1e")
    case "ni" =>
      println("2s")
      a ! "san"
      //as.shutdown
      TimeUnit.MILLISECONDS.sleep(1000)
      println("2e")
    case "san" =>
      println("3s")
      as.shutdown
      TimeUnit.MILLISECONDS.sleep(5000)
      println("3e")
  }
}

val as = ActorSystem.create
val a = as.actorOf( Props(new a()) )
a ! "ichi"
*/


/*
import akka.actor
import akka.actor._
import java.util.concurrent.TimeUnit

class a extends Actor {
  def receive = {
    case "st"=>
      r ! "r"
      while(true){
        c ! "death"
        TimeUnit.MILLISECONDS.sleep(1000)
      }
  }
}

class reeper extends Actor {
  def receive = {
    case x =>
      (0 to 19).foreach{i=>
        c ! "plus"
      }
  }
}

class counter extends Actor {
  var cnt = 0
  def receive = {
    case "plus" =>
      cnt += 1
    case "death" =>
      println("death" + cnt)
      if (cnt > 5) {
        println("shutdorn")
        as.shutdown
      }
  }
}


val as = ActorSystem.create
val a = as.actorOf( Props(new a()) )
val r = as.actorOf( Props(new reeper()) )
val c = as.actorOf( Props(new counter()) )
a ! "st"
*/


/*
// 並行処理 Master/Slave -> 失敗
import akka.actor
import akka.actor._
import java.util.concurrent.TimeUnit

class master extends Actor {
  def receive = {case x =>
    println("Mstart")
    println(x)
    
    val s = as.actorOf(Props(new slave()))
    val lb = new collection.mutable.ListBuffer[ActorRef]
    
    lb.append(s)
    lb.append(s)
    lb.append(s)
    
    lb.foreach {
      _ ! "deach"
    }
    //TimeUnit.MILLISECONDS.sleep(1000)
    //as.shutdown
    println("Mend")
  }
}

class slave extends Actor {
  def receive = {case x =>
    println("Sstart")
    println(x)
    TimeUnit.MILLISECONDS.sleep(1000)
    println("Send")
  }
}


val as = ActorSystem.create
val m = as.actorOf( Props(new master()) )
m ! "uri"
*/



/*
// 並行処理 ActorからActor呼び出し
import akka.actor
import akka.actor._
import java.util.concurrent.TimeUnit

class ichi extends Actor {
  def receive = {case x =>
    println("ichistart")
    println(x)
    TimeUnit.MILLISECONDS.sleep(1000)
    fact.ni ! "death"
    println("ichiend")
  }
}

class ni extends Actor {
  def receive = {case x =>
    println("nistart")
    println(x)
    TimeUnit.MILLISECONDS.sleep(1000)
    fact.san ! "lives"
    println("niend")
  }
}

class san extends Actor {
  def receive = {case x =>
    println("sanstart")
    println(x)
    TimeUnit.MILLISECONDS.sleep(1000)
    fact.as.shutdown
    println("sanend")
  }
}

object fact {
  println("rebirth")
  val as = ActorSystem.create
  val ichi = as.actorOf( Props(new ichi()) )
  val ni = as.actorOf( Props(new ni()) )
  val san = as.actorOf( Props(new san()) )
}

println("start")
fact.ichi ! "go"
println("end")
*/


/*
// 並行処理4 future -> NG ?が使えない
import akka.actor
import akka.actor._
import akka.pattern._
import java.util.concurrent.TimeUnit
import scala.concurrent.Await
import akka.util.Timeout

class act extends Actor {
  println("ueue")
  def receive = {case x =>
    println("acti:" + x)
    TimeUnit.MILLISECONDS.sleep(1000)
    println("acte:" + x)
    sender ! "sensensen"
  }

  println("sita")
}

println("start")

val as = ActorSystem.create
val ref = as.actorOf( Props(new act()) )
//(0 to 1000).foreach{i=>
  val f = ref ! "rec"
  println(f.getClass)
  //f.onSuccess {
  //  case (sss: String) => println(sss)
  //} 
//}
as.shutdown()

println("end")

//val a = ActorSystem.create
//val b = a.actorOf(Props(println("tyabarake")))
//b ! 1
*/


/*
// java標準logging
import java.util.logging._

val l = Logger.getLogger("lll")
l.info("ininin")

val fh = new FileHandler("log.txt")

val format = new XMLFormatter()
fh.setFormatter(format)
l.addHandler(fh)
l.info("ininin")
println("tesa")
*/


/*
// 並行処理3 値の返却 ->NG 値を戻すという考え方が古い
import akka.actor
import akka.actor._
import java.util.concurrent.TimeUnit;

class act extends Actor {
  println("ueue")
  def receive = {case x =>
    println("acti:" + x)
    TimeUnit.MILLISECONDS.sleep(1000)
    println("acte:" + x)
  }
  println("sita")
}

println("start")

val as = ActorSystem.create
val ref = as.actorOf( Props(new act()) )
(0 to 1000).foreach{i=>
  ref ! "rec"
}
//as.shutdown()

println("end")

//val a = ActorSystem.create
//val b = a.actorOf(Props(println("tyabarake")))
//b ! 1
*/



/*
// jar作成
object tmp {
def main(args: Array[String]): Unit = {
  println("testi")
}

println("lkjsdf")
main(Array("asf"))
}


object tmp {
  def main(args: Array[String]): Unit = {
    println("jaaraa")
  }
}
*/


/*
// log出力
import org.slf4j.LoggerFactory
import ch.qos.logback.core.Appender
import ch.qos.logback.core.FileAppender
import ch.qos.logback.core.encoder.Encoder
import ch.qos.logback.core.encoder.LayoutWrappingEncoder
import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.spi.LoggingEvent

val logger = LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME).asInstanceOf[Logger]

val fa = new FileAppender[ILoggingEvent]
fa.setContext(logger.getLoggerContext)
fa.setFile("fa.log")
fa.setAppend(true)

val e = new LayoutWrappingEncoder[ILoggingEvent]
e.setImmediateFlush(true)
e.start()
fa.setEncoder(e)
fa.start()

logger.addAppender(fa)
logger.error("to hell")
logger.warn("to hell")
logger.debug("to hell")
logger.trace("to hell")

//appender.setLayout(layout)
*/




/*
// list delete
var l = new collection.mutable.ListBuffer[String]
l.append("test")
l.append("tesaft")
l.append("tefefeft")
l.append("tesaft")
println(l)
//println(l--=List("tesaft"))
l = l.filterNot(i=>i=="tesaft")
println(l)
*/


/*
// JavaConversions
import scala.collection.JavaConversions._

val al: java.util.ArrayList[String] = new java.util.ArrayList
al.add("test")
al.add("tsdf")
al.add("tssddef")
al.add("test")
println(al.get(0))
println(al.size)
println(al.indexOf("test"))
al.foreach { 
  println(_)
}
*/


/*
// scala List系
val lb = new collection.mutable.ListBuffer[String]
lb.append("test")
lb.append("tesaft")
lb.append("tefefeft")
lb.append("test")
lb.foreach { 
  println(_)
}


val hm = new collection.mutable.HashMap[String,String]
println(hm.update("aa","bbb"))
hm.update("tfeetk","bbb")
println(hm.update("aa","bbb"))
println(hm.put("testk","tstv"))
hm.put("tfeetk","tsdfdstv")
hm.put("tsdfsdftk","tesafstv")
println(hm.put("testk","teestv"))
hm.update("tfeetk","ooo")
hm.put("tfeetk","eee")
println(hm.size)
println(hm.get("testk"))
println(hm.contains("testk"))
hm.foreach { i =>
  println(i._1 + ":" + i._2)
}
*/



/*
// java List系
//val jl: java.util.List[String] = new java.util.List

// 配列
val al: java.util.ArrayList[String] = new java.util.ArrayList
al.add("test")
al.add("tsdf")
al.add("tssddef")
al.add("test")
println(al.get(0))
println(al.size)
println(al.indexOf("test"))
for(i <- 0 until al.size)
  println(al.get(i))


// 挿入削除が高速な配列
val ll: java.util.LinkedList[String] = new java.util.LinkedList
ll.add("test")
ll.add("tsdf")
ll.add("tssddef")
ll.add("test")
println(ll.get(0))
println(ll.size)
println(ll.indexOf("test"))
for(i <- 0 until ll.size)
  println(ll.get(i)) // getはArrayが高速


// 重複しない順不同
val hs: java.util.HashSet[String] = new java.util.HashSet
hs.add("test")
hs.add("tsdf")
hs.add("tssddef")
hs.add("test")
println(hs.size)
println(hs.contains("test"))
val it = hs.iterator
while(it.hasNext)
  println(it.next)

// 重複しないソート
val ts: java.util.TreeSet[String] = new java.util.TreeSet
ts.add("test")
ts.add("tsdf")
ts.add("tssddef")
ts.add("test")
println(ts.size)
println(ts.contains("test"))
val it = ts.iterator
while(it.hasNext)
  println(it.next)

// kvp
val hm: java.util.HashMap[String,String] = new java.util.HashMap
hm.put("testk","testv")
hm.put("tfeetk","tsdfdstv")
hm.put("tsdfsdftk","tesafstv")
hm.put("testk","teestv")
println(hm.size)
println(hm.get("testk"))
println(hm.containsKey("testk"))
val it = hm.keySet.iterator
while(it.hasNext) {
  val o = it.next
  println(o + ":" + hm.get(o))
}


// kvpでソート
val tm: java.util.TreeMap[String,String] = new java.util.TreeMap
tm.put("testk","testv")
tm.put("tfeetk","tsdfdstv")
tm.put("tsdfsdftk","tesafstv")
tm.put("testk","teestv")
println(tm.size)
println(tm.get("testk"))
println(tm.containsKey("testk"))
val it = tm.keySet.iterator
while(it.hasNext) {
  val o = it.next
  println(o + ":" + tm.get(o))
}
*/



/*
// 外部ファイル読み込み
import module._

val a = new mod()
a.pon
*/

/*
// trait
trait moduler {
  def pri = {
    println("module!")
  }
}

println("triant")

class a extends moduler
val b = new a
b.pri
*/



/*
import com.google.gson._
import scala.collection.JavaConversions._

val g: Gson = new Gson
val json = "[\"ichi\",\"ni\"]"
println(json)
val a = g.toJson(json)
println(a)
println(g.fromJson(a, classOf[String]))

val jb: java.util.List[String] = List("fe","saf")
println(jb)
println(g.toJson(jb))
*/


/*
// gson4 デシリアライズ(Json -> Javaオブジェクト)
import com.google.gson._
import scala.collection.JavaConversions._

class Bydo{
  var kiga: String = _
//  var tuku: String = _
//  var towa : Integer = _
//  var tashi: Integer = _
//  var haba: List[String] = _ 
}

//val map = Map(
//  "kiga" -> "ido"
//  "tuku" -> "nina",
//  "towa" -> 12,
//  "tashi" -> 2,
//  "haba" -> List("tute","ita")
//)

val j: String = "{\"kiga\":\"tuku\"}"

val g: Gson = new Gson
val b: Bydo = new Bydo
val t: Bydo = g.fromJson( j, b.getClass )
println(g.fromJson( j, b.getClass ))
*/




/*
// toJson
import com.google.gson._
import scala.collection.JavaConversions._

val g: Gson = new Gson

//var map = Map("kanoku"->"vanoku", "ktara"->null)
//val jMap: java.util.Map[String, String] = map

//val gb: Gson = new GsonBuilder().setPrettyPrinting().create()
//val gb: Gson = new GsonBuilder().serializeNulls().create()
//println(gb.toJson(map))
//println(gb.toJson(jMap))

class Bydo (pa:String,ru:String){
  var s2: String= pa
  var s3: String= ru
  var value1: String = "kiga"
  var value2: String = "tuku"
  var value3: String = "42"
  
  override def toString = "noinoi"
}

val b: Bydo =  new Bydo("fefe","asf")
println( b.value1 )
println( b.value2 )
println( b.value3 )
println( b.s2 )
println( b.s3 )

println(b)

val jb: String = g.toJson( b, classOf[Bydo] )
println( jb )

val j = "{pa:\"asf\"}"
val a: Bydo = g.fromJson(j , classOf[Bydo])
println(a)
*/


/*
val arr = new Array[String](3)
arr(0) = "towa"
arr(1) = "tashi"
arr(2) = "haba"

val ja = g.toJson( arr )
println( ja )
*/

/*
// fromJson
import com.google.gson._
import scala.collection.JavaConversions._

val g: Gson = new Gson
val str = g.fromJson("123", classOf[String])
val num = g.fromJson("123", classOf[Integer])
println(str + 2)
println(num + 2)
*/

/*
// List
import java.util._

var l: List[String] = new ArrayList[String]
l.add("asdf")

println(l)
*/


/*
class hako {
  var para:String = _
  
  def don = {
    this.para = "don"
  }
  
  override def toString = this.para
}


val re = new hako
println(re.para)
re.para="nanika"
println(re.para)
re.don
println(re.para)
println(re)
*/




/*
// constructor3
class hako(para: String,meta: Integer) {
  def this(para: String) = this(para, 99)
  def this(meta: Integer) = this("nai",meta)
  
  override def toString = para + ":" + meta
}

println(new hako("st", 7))
println(new hako("st"))
println(new hako(4))
*/





/*
// constructor2
class hako(para: String,meta: String) {
  override def toString = para + ":" + meta
}

println(new hako("st", "asf"))
*/

/*
// constructor
class hako(para: String,meta: String) {
  var param = para
  var metar = meta
}

val rect = new hako("papapa", "mmemme")


println(rect.param)
println(rect.metar)
*/

/*
// gson3 gsonbuilder
import com.google.gson._
import scala.collection.JavaConversions._

val g: Gson = new Gson()
var map = Map("kanoku"->"vanoku", "ktara"->null)
val jMap: java.util.Map[String, String] = map

val gb: Gson = new GsonBuilder().setPrettyPrinting().create()
//val gb: Gson = new GsonBuilder().serializeNulls().create()
println(gb.toJson(map))
println(gb.toJson(jMap))
*/



/*
// uriを抽出
val url = "http://yahooo"
val r = "^http".r

if ( r.findFirstIn(url) == Some("http") ) {
  println("is url")
} else {
  println("is not url")
}
println("  sadlkfj  ".trim)

*/


/*
// ファイルに追記
import java.io.FileWriter

val o = new FileWriter("write.txt", true)
o.write("hell...\n")
o.close
*/


/*
// 同じファイルが存在していたら削除
import java.io.PrintWriter
import java.io.File

val o = new PrintWriter("write.txt")
o.println("hell...\n")
o.close

val f = new File("write.txt")

if(f.exists) {
  println("ari")
  f.delete
}else{
  println("nasi")
}
*/



/*
// ファイル読み込み
import scala.io.Source

val s = Source.fromFile("README.md")

try {
  for(line <- s.getLines) {
    println(line)
  }
} finally{
  s.close
}
*/

/*
// ファイル存在確認
import java.io.File

val f = new File("README.md")
if(f.exists) println("ari")
*/



/*
// 引数取得
if (args.length != 1) sys.exit()
println( args(0) )
*/



/*
// logger (java)
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

println("sadf")

// logback
val logtest = LoggerFactory.getLogger("tmpp")

logtest.debug("Hello Logger");

//logtest.fatal("本当にやばいログ　　");
logtest.error("普通にやばいログ　　");
logtest.warn( "ちょっとやばいログ　");
logtest.info( "運用時に必要なログ　");
logtest.debug("開発時に必要なログ　");
logtest.trace("デスマ時に必要なログ");
*/





/*
// gson2 Map
import com.google.gson._
import scala.collection.JavaConversions._

val g: Gson = new Gson()
var map = Map("kanoku"->"vanoku", "ktara"->"vtara")
println(g.toJson(map))  

val jMap: java.util.Map[String, String] = map
println(g.toJson(jMap))  
*/


/*
// gson
import java.io._
import com.google.gson._
import com.google.gson.annotations._
import com.google.gson.stream._


class BagOfPrimitives {
  val value1 = 1
  val value2 = "abc"
  val value3 = 3
}


println( "test" )


val g: Gson = new Gson()
//val obj = new BagOfPrimitives
//val obj: BagOfPrimitives = new BagOfPrimitives
//println( g )
//println( obj )
//println( BagOfPrimitives.value1 )
//println( BagOfPrimitives.value2 )
val obj = new Array[String](3)
obj(0) = "sdf"
obj(1) = "23r"
obj(2) = "24twe"
println( g.toJson( obj ) )
//println( g.toJson( BagOfPrimitives ) )
*/





/*
// json2 ぜんぜんダメ
//import org.json4s._
//import org.json4s.native.JsonMethods._
//import org.json4s.jackson.JsonMethods._

object tmp { def main(args: Array[String]): Unit = {

//parse(""" { "numbers" : [1, 2, 3, 4] } """)

//println( parse(""" { "numbers" : [1, 2, 3, 4] } """) )
//println( parse("""{"name":"Toy","price":35.35}""", useBigDecimalForDouble = true) )

//println( "test" )
}}
*/

/*
// 整理2
import yaml._
import redis.clients.jedis._;

println( "test" )
*/


/*
// 整理
import yaml._
import redis.clients.jedis._;

object tmp { def main(args: Array[String]): Unit = {
  println( "test" )
}}
*/


/*
// json
import org.json4s._
//import org.json4s.native.JsonMethods._
import org.json4s.jackson.JsonMethods._

object tmp { def main(args: Array[String]): Unit = {
  println( parse(""" { "numbers" : [1, 2, 3, 4] } """) )
  println( parse("""{"name":"Toy","price":35.35}""", useBigDecimalForDouble = true) )
  println(  )
}}
*/


/*
// 並行処理2 ラウンドロビン
import akka.actor
import akka.actor._
import akka.routing.RoundRobinRouter

class PrintActor extends Actor {
  def receive = {
    case x => println(x)
    //case x => x == x
  }
}

val sys = ActorSystem("as")
//val act = sys.actorOf(Props(new PrintActor), "nanamee")

//(0 to 1000).foreach(act ! _) 
  //act ! scala.util.Random.alphanumeric.take(8).mkString
//  act ! i
//}

val router = sys.actorOf(Props(new PrintActor).withRouter(RoundRobinRouter(2)))
(0 to 1000*1000).foreach(router ! _) 

Thread.sleep(1000)
//sys.shutdown
*/


/*
// 並行処理
import akka.actor
import akka.actor._
import java.util.concurrent.TimeUnit;


class act extends Actor {
  //val nanika = scala.util.Random.alphanumeric.take(8).mkString
  val nanika = "a:" + System.currentTimeMillis()
  def receive = {case "rec" =>
    println("act:" + nanika)
  }
}

val sys = ActorSystem.create
val ref = sys.actorOf( Props(new act()) )
TimeUnit.MILLISECONDS.sleep(1000);
val ref2 = sys.actorOf( Props(new act()) )

ref ! "rec"
TimeUnit.MILLISECONDS.sleep(1000);
ref2 ! "rec"

sys.shutdown()

println("Finished")
*/





/*
// https通信 レスポンス取得
import java.net.URL
import java.net.HttpURLConnection
import sun.net.www.protocol.https.HttpsURLConnectionImpl

//val url = new URL("http://api.hostip.info/country.php")
//val url = new URL("http://yahoo.co.jp/")
val url = new URL("http://www.yahoo.co.jp/")
//val url = new URL("http://yahooo.co.jp/anokutara")
//val url = new URL("http://yahoo.co.jp/anokutara")
//val url = new URL("http://nochint.co.no")
//val url = new URL("https://translate.google.co.jp/")
//val url = new URL("https://www.java.net/")
//val url = new URL("http://www.java.net/")

val conn = url.openConnection().asInstanceOf[HttpURLConnection]
//val conn = url.openConnection()
println(conn.getClass())
conn.setInstanceFollowRedirects(false)
println(conn.getResponseCode())

println(conn.getHeaderFields())

// Body取得
val in = conn.getInputStream()
val bodyByte = new Array[Byte](1024)
while(in.read(bodyByte) != -1){
println(new String(bodyByte, "utf8"))
}
//println(ir)
in.close()
*/




/*
// http通信 レスポンス取得4
import java.net.URL
import java.net.HttpURLConnection

//val url = new URL("http://api.hostip.info/country.php")
//val url = new URL("http://yahoo.co.jp/")
val url = new URL("http://www.yahoo.co.jp/")
//val url = new URL("http://yahooo.co.jp/anokutara")
//val url = new URL("http://yahoo.co.jp/anokutara")
//val url = new URL("http://nochint.co.no")

val conn = url.openConnection().asInstanceOf[HttpURLConnection]
conn.setInstanceFollowRedirects(false)
println(conn.getResponseCode())
*/


/*
// http通信 レスポンス取得3
import java.net.URL
import java.net.HttpURLConnection

//val url = new URL("http://api.hostip.info/country.php")
//val url = new URL("http://yahoo.co.jp")
//val url = new URL("http://yahooo.co.jp/anokutara")
val url = new URL("http://yahoo.co.jp/anokutara")
//val url = new URL("http://nochint.co.no")

val conn = url.openConnection().asInstanceOf[HttpURLConnection]
conn.setInstanceFollowRedirects(false)
val map = conn.getHeaderFields()
println(conn.getResponseCode())
//println(map.isEmpty)
println(map)
//val rc = conn.asInstanceOf[HttpURLConnection].getResponseCode()
//println(rc)
*/


/*
// http通信 レスポンス取得2
import java.net.URL
import java.net.HttpURLConnection
import scala.collection.JavaConversions._

val url = new URL("http://api.hostip.info/country.php")
//val url = new URL("http://yahoo.co.jp")
//val url = new URL("http://nochint.co.no")

  val conn = url.openConnection()
println(conn.getClass())
//val map = conn.getHeaderFields()
////val header = conn.getHeaderField(null)
val rc = conn.asInstanceOf[HttpURLConnection].getResponseCode()
println(rc)
//println(url)
//println(conn)
//println(map)

//for (e <- map)
//{
//  println(e(1))
//}

//map.foreach { case(k,v)=>
//  println("-----------------")
//  println(k.getClass())
//  println(v.getClass())
//}

//val ural = map(null)
//println(ural.get(0))

println("death")
*/

/*
// http通信 レスポンス取得
import scala.io.Source
object tmp { def main(args: Array[String]): Unit = {

val source = Source.fromURL( "http://api.hostip.info/country.php", "utf8" )
//println( source )
println( source.getLines.mkString )

}}

import scala.io.Source
val source = Source.fromURL( "http://api.hostip.info/country.php", "utf8" )
println( source.getLines.toList )

*/


/*
// ダイジェスト
import java.security.MessageDigest

class Sha1Digest(str: String) {
  val digestString: String = {
    val md = MessageDigest.getInstance("SHA-1")
    md.update(str.getBytes)
    md.digest.foldLeft("") { (s, b) => s + "%02x".format(if(b < 0) b + 256 else b) }
  }
}

object App {
  def main(args: Array[String]) =
    List("全部", "違う", "値になります").foreach { str => println(str.digestString) }

  implicit def String2Sha1Digest(s: String): Sha1Digest = new Sha1Digest(s)
}
*/

/*
// ランダムな文字列の生成(英数字)
println(scala.util.Random.alphanumeric.take(8).mkString)
*/

/*
// ランダムな文字列の生成(記号付き)
import scala.util.Random

def getRandomStr(n: Int):String = {
  val s =
    ('a' until 'z').toList :::
    ('A' until 'Z').toList :::
    (0 until 9).toList :::
    List("+", "$", "%")

  if (n <= 0 || n > s.length) return ""
  
  Random.shuffle(s).mkString("").slice(0, n)
}

//if (args.length != 1) sys.exit()
//println(getRandomStr(args(0).toInt))
println( getRandomStr(8) )
*/



/*
// scalaストップウォッチ
import java.util.concurrent.TimeUnit;

val starttime = System.currentTimeMillis();

TimeUnit.MILLISECONDS.sleep(1);

val endtime = System.currentTimeMillis();

println(endtime - starttime)
*/


/*
// sleep
import java.util.concurrent.TimeUnit;
println("test")
TimeUnit.SECONDS.sleep(1);
println("test")
*/


/*
import org.scalatra._

object tmp {
def main(args: Array[String]) = println("")
  println("mi-acat")
  println("asdf")

}

class HelloWorldApp extends ScalatraServlet {
  get("/") {
    <h1>Hell</h1>
  }
}
*/



/*
// ビットシフト
var n = 4
var r = 8
println( -8 << 1 )
println( -8 >> 1 )
println( -8 >>> 1 )
println( 6 & 4 )
println( 16 ^ 15 )
*/

/*
// インクリメント件
var a = 0
val b = a += 1
println(a)
println(b)
println(1.+(2))
println(1+2)
println(1 + 2)
println(("aa,dd" split ",")(1))
println(("aa,dd".split(","))(1))

var y = 3
y += 2
println(y)

var z = 3
z =z.+(2)
println(z)
*/

/*
// 三項演算子の代用
val sanko = if(true) "ttt" else "fff"
println(sanko)
*/



/*
// tuple
val tu = ("tt","uup","lll","eee")
println(tu)
println(tu._1)
println(tu._3)
*/



/*
// map
val m = Map[String,String]("ai"->"ao", "syu"->"aka", "sou"->"midori")
println(m)
println(m.head)
println(m("syu"))
println(m.empty)
println(m + ("enji"->"hi"))
println(m - "sou")
println(m.keySet)
println(m.values)
*/



/*
// List
val liste=List("sdf")
println(liste(0))
val lislis = "luck" :: liste
println(lislis.head)
val liskis = lislis.::("cruel")
println(liskis.head)

liskis.find(n=>n=="sdf")
println(List("sdfsdfs").getClass)
*/


/*
// splitと配列
val stt = "sadf,eref,asdf"
val arst = stt.split(",")
println(arst(0))
println(arst{1})

println(arst.size)
println(arst.length)
println(arst.head)
println(arst.tail.head)
println(arst.isEmpty)

println( (arst.find( n => n == "eref" )) )

val hoge = Array(10,20,30,40)
hoge(0) = 100
println(hoge(0)) // 100って表示される

val arr =Array(5,2,3,4)
println( arr.find(n=>n==6) )
*/


/*
// enum
object Enuenu extends Enumeration {
  type Enuenu = Value
  val Ichi = Value("one")
  val Ni = Value("two")
  val San = Value("three")
}
println(Enuenu.values)

val moji = Enuenu.Ni.toString()

val enu = Enuenu.Ni
println(enu match {
  case Enuenu.Ni => enu
  case _ => "mu"
})

// 正規表現リテラル
val strin = "abcde"
var qwert = "qwert"

val we = "we".r
val lr = List("we".r)

if (strin.contains("bcd")) {
  println("in")
}


val mamama = "abdao3"
val r = "(abc)(123)".r;
println( mamama match {
  case "dao" | "o3" | "abdao3" => "ari"
  case "abo3" => "ari2"
  case _         => "nothing"
});
*/



/*
// 正規表現
println("testesers")
val s = "abcde"
val r = "bcd".r
val z = "zzza".r

for(m <-  r.findAllIn(s).matchData)
{
  println("r match")
  println(m)
}

for(m <-  z.findAllIn(s).matchData)
{
  println("z match")
  println(m)
}

val t = "qqqzzzeee"
t match {
  case z => {
    println("zzz match")
  }
}


//val g = new scala.util.matching.Regex("rrr", "ggg", "ppp")
val v = "vvv".r

t match {
  case v => println("list match");
  case _ => println("un match")
}
*/


/*
// リクエスト
import dispatch._
import Defaults._

object tmp { def main(args: Array[String]) {
println("asdf")

val svc = url("http://api.hostip.info/country.php")
val country = Http(svc OK as.String)
println(country())

println("end")
}}
*/

/*
// sbt練習
object Hell {
  def main(args: Array[String]) = println("Hells...")
  println("mi-acat")
}
*/



/*
// 偶数ならば処理する
def isEven(i: Int) = i % 2 == 0

for {i <- 1 to 100 if isEven(i)}
  println(i)
*/



/*
// xmlリテラル
val name = "anokutara"
println(<author>{name}</author>)
*/



/*
val u = ()
*/



/*
// forのネスト
for { i <- 1 to 10
  j <- 1 to 10 }
{
  println(i.toString + " " + j.toString)
}
*/




/*
class  MyTest { val inClass  = 1 }
object MyTest { val inObject = 2 }
*/



/*
class MyTest {
  def hoge1(x: Int) = x + 1
  def hoge2(x: => Int) = x + 1
  def hoge3(x: () => Int) = x() + 1
}
*/


/*
// defの定義で、引数なしと空括弧は微妙に違う
def a = 1
def b() = 1
println(a)
println(b())

// 引数無しで定義すると"func1()"では呼び出せない
//println(a())
// 空括弧で定義すると"func2()"でも"func2"でも呼び出せる
println(b)


def func1 = (_: Int) + 1
def func2() = (_: Int) + 1

println(func1)
//println(func1())

println( func2 )
println( func2() )

println( func1(5) )
//println( func2(5) )
println( func2()(5) )
*/


/*
class MyTest {
  def hoge1(x: String): Int = x.length
  def hoge2: String => Int = x => x.length
}
*/

/*
// メソッドと関数型のフィールドは違う
//def hoge(x: String): Int = x.length
def hoge(x: String): Int = {
  x.length
}
println(hoge("abcde"))
println(hoge(x = "abcde"))

//def fuga: String => Int = x => x.length
def fuga: String => Int = {
  x => x.length
}
println(fuga("abcde"))
//println(fuga(x = "abcde"))
println(fuga(v1 = "abcde"))
*/



/*
// クラス定義のvar、def、val はメソッド
class ValVarDef {
  val x = 1
  var y = 2
  def z = 3
}
*/



/*
// Actorの利用
import akka.actor
import akka.actor._

var variable = 0
val LOOP = 1000 * 1000 * 1000

def increment() = {
  //this.synchronized {
    variable = variable + 1
  //}
}

class da extends Actor {
  def receive = {case "helll" =>
    for( i <- 0 until LOOP )
      increment()
    println("nanigari")
    println(variable)
  }
}

val sys = ActorSystem.create
val ref = sys.actorOf(Props(new da()))

class da2 extends Actor {
  def receive = {case "helll" =>
    for( i <- 0 until LOOP )
      increment()
    println("nanigari")
    println(variable)
  }
}

val sys2 = ActorSystem.create
val ref2 = sys2.actorOf(Props(new da2()))

ref ! "helll"
//ref2 ! "helll"

sys.shutdown()
sys2.shutdown()


println(variable)
println("Finished")
*/


/*
// yaml読み込み→NG
import org.yaml.snakeyaml.Yaml

Yaml.load("config.yml")
*/



/*
// ファイル読み込み
import scala.io.Source
Source.fromFile("config.yml").getLines.foreach(println)
*/


/*
// playクラス
object Hello {
  def main(args: Array[String]): Unit = {
    println("Hell, world!")
  }
}
*/

/*
// 強力な無名ブロックの引数
var gt = List(1,2,3).sortWith(_<_)
var lt = List(1,2,3).sortWith(_>_)

println(gt)
println(lt)
*/


/*
// Jedisの実装
import redis.clients.jedis._;

var jedis = new Jedis("localhost")
jedis.set("key", "value")
println( jedis.get("key") )
*/


/*
// 文字列操作
var str = "abcdefgzyzyxzxz"
println(str.substring(0, 2))
println(str.substring(1, 2))
//println(str.substring(1, -1))
println(str.substring(1, 1))
println(str.substring(1, str.size))
//println(str.substring(1, str.size + 1))
println(str.substring(5, str.size))

println(str.toString)
println(str + str)
*/

/*
// s補間子
println(s"abc ${ 123 } def")
val foo = "bar"
println(s"abc ${foo} def ${ 1+2 }")
// 変数名のときは{}で囲まなくてもよい
println(s"abc $foo def")
println(s"""abc $foo def""")
// ネストできる
println(s"ab${ s"c $foo d" }ef")
*/

/*
// f補間子
// %を付けて書式を指定できる。
println(f"abc ${ 12 }%04d def")
val zzz = 12
println(f"abc=$zzz%04d")
println(f"abc=$zzz")
*/

/*
// raw補間子
println(raw"abc\ndef")
val dir = raw"C:\temp"
val f = raw"$dir\new1"
println(f)
*/

/*
// s補間子の実体
val foo = "asdf"
val str = s"abc ${foo} def ${ 1+2 } ghi"
println(str)

val sc = StringContext("abc ", " def ", " ghi").s(foo, 1+2)
println(sc)
*/


/*
// 生文字リテラル（raw string literal）
// 複数行文字列リテラル
println("abc\nde")
println("""abc\nde""")
println("abc\\nde")
println("""abc\\nde""")
*/

/*
// symbol
println("abc" eq new String("abc"))
println('abc eq Symbol("abc"))
println("abc" == new String("abc"))
println('abc == Symbol("abc"))
*/

/*
// 文字列検索
println( "abc_abc".replaceAll( "abc", "123" ) );
println( "abc_abc".replaceAll( "[a-z]+", "123" ) );
println( "abc_abc".replaceAll( "[a][b][c]", "123" ) );
println( "abc_abc".contains( "abc" ) );
println( "abc_abc".indexOfSlice( "abc", 0 ) );
println( "abc_abc".indexOfSlice( "abc", 1 ) );
println( "abc_abc".indexOf( "abc" ) );
println( "abc_abc".indexOf( "abc",1 ) );
// 正規表現ではない
println( "abc_abc".indexOfSlice( "[a-z]+", 0 ) );
*/

/*
// regex
val r = "([a-z]+)".r; // .r をつけると Regex オブジェクトができる。
r.findAllIn( "abc_def" ).matchData.foreach(
  m => println( m.group( 1 ) )
);
println(r)
println("([a-z]+)")
println("([a-z]+)".r)


val r = "([a-z]+)_([0-9]+)".r;
r.findAllIn( "abc_123, def_456" ).matchData.foreach(
  m => println( m.group( 1 ) + ", " + m.group( 2 ) )
);

val r = "([a-z]+)_([0-9]+)".r;
r.findAllIn( "abc_123, def_456" ).matchData.foreach(
  m => println( m.group( 0 ) + " ( " + m.start + " ~ " + m.end + " )" )
);

val r = "([a-z]+)([0-9]+)".r;
println( "abc123" match {
  case r( a, n ) => a + ", " + n;
  case _         => ""
} );


"123" match {
  case _ => ""
}
*/

/*
val s = "GGACGATATAATTTATAATACCGT"
val r = "TATAA".r   // Stringは.rで正規表現に変換できる
for(m <- r.findAllIn(s).matchData)
  println("Found a match in [%s, %s)".format(m.start, m.end))
*/

/*
// マッチをグループにわける
val r = "(chr)([0-9]+)".r
val l = List("chr1", "chr10", "chr21")
for(chr <- l; m <- r.findFirstMatchIn(chr)) {
  val chrPrefix = m.group(1)
  val chrNum = m.group(2)
  println("prefix:%s, num:%s".format(chrPrefix, chrNum))
}
*/

/*
// マッチグループに名前を付ける
val r = new scala.util.matching.Regex("(chr)([0-9]+)", "prefix", "num")
val l = List("chr1", "chr10", "chr21")
for(chr <- l; m <- r.findFirstMatchIn(chr)) {
  println("prefix:%s, num:%s".format(m.group("prefix"), m.group("num")))
}
*/

/*
println("adsf"*3)
"asdf".foreach(
  m => println(m)
)
println("adsf"(3))
println("adsf".charAt(3))

println("abc" > "def")
println("abc" < "def")

val builder = new StringBuilder()
builder.append("abc")
println(builder)

"abc".addString(builder)
println(builder)

// 引数に開始、区切り、終了文字
( "abc" addString(builder, "[", ",", "]") ).toString
println(builder)

println("mac".capitalize)
println("mac".toUpperCase)
println("mac".toLowerCase)

// AとCだけ大文字に変換する
println("mac".collect { case 'a' => 'A'; case 'c' => 'C'; case x => x })

println("linux" compare "windows")
println("linux" compareTo "windows")
println("linux".compare("windows"))
println("windows" contains "dow")
println("windows".contains("dow"))

// 「w」の出現回数をカウント
println("windows".count { _ == 'w' })

// アルファベット大文字の数をカウント
println("AbcDeF".count { c => c >= 'A' && c <= 'Z' })

// 差分 対象となるのは左辺のみ
println("abc" diff "bcd")
println("aabbcc" diff "abbc")

println("ABCABDACBADB".distinct)
println("Windows".drop(3) )
println("Windows" dropRight 3)

// 「d」が出現するまでdrop
println("Windows" dropWhile {_ != 'd'} )

// 末尾が指定した文字列で終わっているか。
println("linux" endsWith "ux" )
println("linux" endsWith "ws" )

println("linux" equals "LINUX")
println("linux" equalsIgnoreCase "LINUX")

println("linux" exists {_ == 'x'})

// 大文字小文字を無視して、A〜F以外は落とす
println("Alphabet" filter {c => c.toUpper  >= 'A' && c.toUpper <= 'F'})

// 逆にA〜Fを落とす
println("Alphabet" filterNot {c => c.toUpper  >= 'A' && c.toUpper <= 'F'} )
*/



/*
// 指定文字列の文字数が８の倍数桁ではない場合に
// 文字列を加算して、８の倍数桁に整える関数
private def _multipleOfEight(target: String): String = {
  var targetTrim = target
  
  val addNum = targetTrim.length % 8
  if (addNum != 0) {
    val appendString = "12345678"
    val appendStringTrim = appendString.substring(0, 8 - addNum)
    targetTrim = targetTrim + appendStringTrim
  }
  
  targetTrim
}

println(_multipleOfEight("1234567812345678"))
//println( 11 % 8 )
//println( 33.0 / 8 )
//println( Math.ceil(33.0 / 8) )
//println( Math.ceil(33.0 / 8).toInt * 8 )
//println( "abc".padTo(8, "0").mkString )
*/




/*
val parsedText = "[PAGE_IMAGE_TAG_2] <a>aaa</a> [PAGE_IMAGE_TAG_3]<div>asdf</div>[PAGE_IMAGE_TAG_3] ZZZZ"
var headParsedText = parsedText

headParsedText = headParsedText.replaceAll("<(\"[^\"]*\"|'[^']*'|[^'\">])*>", "")
headParsedText = headParsedText.replaceAll("\\[(\"[^\"]*\"|'[^']*'|[^'\"\\]])*\\]", "")

println(headParsedText)
*/


/*
import scala.util.matching.Regex

// 正規表現
val replaceAnchorHead = "cd"

// テンプレート
var result = "abcdecdfg"

// リプレイスする部分を取得
val regex = new Regex(replaceAnchorHead)
val mi = regex.findAllIn(result).matchData

val parsedText = "[PAGE_IMAGE_TAG_2] aaa [PAGE_IMAGE_TAG_3]"

//parsedtextがvalだったので、varに変更
var headParsedText = parsedText

headParsedText = headParsedText.replaceAll("<(\"[^\"]*\"|'[^']*'|[^'\">])*>", "")
headParsedText = headParsedText.replaceAll("""\[.*\]""", "")

val li = mi.toList.reverse

li.foreach{ m =>
  println(m)
  val target = result.substring(m.start, m.end)
  
  try {
    val length = m.group(1).toInt
    
    // テキストを長さ分で切る。
    val headString = if (parsedText.length > length) parsedText.substring(0, length) else parsedText
    result = result.patch(m.start, headString, target.length)
  }
}
println(result)
*/




/*
// immutable
val list = List(1,2,3,4) // 型パラメータをつけるとList[Int](1,2,3)になるが推論可能
val map = Map("a" -> "aa", "b" -> "bb") // Map[String,String]()
*/


/*
// コレクション
println(1.to(3))
println(1.until(3))
*/


/*
// while
var i = 0
while (i < 5 ) {
  println(i)
  i += 1
}
*/

/*
// for式
for( i <- 0 until 5 ) println(i)
*/


/*
//foreach
(0 until 5) foreach { (i) => println(i) }
*/



/*
// Listのmap()
val strList = List("1", "2", "3")
val intList = List(1, 2, 3)

// 改善前
val newIntListForConvert = scala.collection.mutable.ListBuffer.empty[Int]

strList.foreach{ str =>
    //今思い返しても恥ずかしい…   
    newIntListForConvert += str.toInt
}

//val newIntList = newIntListForConvert.toList

val newIntList = strList.map(_.toInt) //なんと…
val newStrList = intList.map(_.toString) //1行で…!

println(newIntList)
println(newStrList)
*/



/*
// Optionのmap()
val optIntVal: Option[Int] = Some(10)
val optStrVal: Option[String] = Some("文字列だす")

//val strVal = optStrVal.getOrElse("") //よくやる
//println(strVal)

// 改善前
//var strVal = ""
//if(optIntVal.isDefined){
//  strVal = optIntVal.get.toString
//}

// 改善後
val strVal = optIntVal.map(_.toString).getOrElse("") //1行で書けた!

//val optStrValForConvert:Option[String] = optIntVal.map(_.toString) //Option[Int]から、Option[String]への変換
//val strVal = optStrValForConvert.getOrElse("")

println(strVal)
*/


/*
// scalacでコンパイルする際はクラスやらmainメソッドが必要
object skarasi
{
  def main(args: Array[String]): Unit =
  {
    println("skarasi")
  }
}
*/


/*
// 関数リテラルはクロージャ
val outer = 10

// 構文スコープの外で定義した変数にアクセス可能
val funcLiteral = (y: Int) => y * outer
println(funcLiteral(2))
*/

/*
// scalaにおけるswichのやりかた
var variable = "aa"
variable match
{
  case "" =>
    println("カラ")
    println("カラ")
    println("カラ")
  case "2" => println("に")
  case _ => println("default")
}
*/



/*
// varとvalの違い
var aru = "rrr"
val eru = "lll"

println(aru)
println(eru)

aru = "aruaru"
eru = "erueru" // valは変更が不可

println(aru)
println(eru)
*/

/*
// scala地獄ナリ
println("hell world")
*/
