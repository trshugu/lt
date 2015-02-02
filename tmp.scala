/*
object tmp { def main(args: Array[String]): Unit = {
}}
*/






/*
def map = Map(
  0 -> "RE",
  9 -> "A"
)

println( map.values.find(n=>n=="RE") match{
  case Some(x)=>x
  case None => None
} )

println(map.get(3))

val res = for(
  (a,b) <- map
  if (b == "REA")
) yield (a,b)

println (res)
println (res.keys)

val src = "RE,mo".split(',')
//println(src)
//src.foreach(println)

val vaaa = for{
  i <- src
  (k,v) <- map
  if (v == i)
} yield k

println(vaaa)
*/



/*
// 並列リストの時間計測
val sstart = System.currentTimeMillis();
val s = (1 to 2147483647).aggregate(BigDecimal(0))( (d, n) => d - n,(d1, d2) => d1 + d2)
val send = System.currentTimeMillis();
println(s)
println(send-sstart);

val pstart = System.currentTimeMillis();
val p = (1 to 2147483647).par.aggregate(BigDecimal(0))( (d, n) => d - n,(d1, d2) => d1 + d2)
val pend = System.currentTimeMillis();
println(p)
println(pend-pstart);
*/



/*
// リストの出現数算出
val gosanke = List("Goro", "Hideki", "Hiromi", "Hideki", "Goro", "Hideki")
val countByGosanke = (Map.empty[String, Int] /: gosanke) { (r, e) =>
  r + (e -> (r.getOrElse(e, 0) + 1))
} 

println(countByGosanke)
println(Map("as"->2) + ("as"->3))
*/


/*
// 並列確認
(1 to 10).fold(0){case (a,b) => println(a + " " + b);a-b}
(1 to 10).par.fold(0){case (a,b) => println(a + " " + b);a-b}
println( (1 to 10).fold(0)((z, n) => z - n) )
println( (1 to 10).par.fold(0)((z, n) => z - n) )
*/



/*
// scan 直列のみ
println( (1 to 5).scanLeft(0)((z,n) => z - n) )
println( (1 to 5).scanRight(0)((n,z) => n - z) )
println( (1 to 5).par.scanLeft(0)((z,n) => z - n) )
println( (1 to 5).par.scanRight(0)((n,z) => n - z) )
*/

/*
// reduce
println( (1 to 100).reduce((z, n) => z - n) )
println( (1 to 100).reduceLeft((z, n) => z - n) )
println( (1 to 100).reduceRight((z, n) => z - n) )
println( (1 to 100).reduceOption((z, n) => z - n) )
println( (1 to 100).reduceLeftOption((z, n) => z - n) )
println( (1 to 100).reduceRightOption((z, n) => z - n) )

println( (1 to 100).par.reduce((z, n) => z - n) ) // 並列
println( (1 to 100).par.reduceLeft((z, n) => z - n) )
println( (1 to 100).par.reduceRight((z, n) => z - n) )
println( (1 to 100).par.reduceOption((z, n) => z - n) ) // 並列
println( (1 to 100).par.reduceLeftOption((z, n) => z - n) )
println( (1 to 100).par.reduceRightOption((z, n) => z - n) )
*/



/*
// aggregate
println(
  List(1,3,5,7).aggregate(BigDecimal(0))(
    (d, n) => d - n,
    (d1, d2) => d1 * d2 // 直列の場合使われない
  )
)

println(
  List(1,3,5,7).par.aggregate(BigDecimal(0))(
    (d, n) => d - n,
    (d1, d2) => d1 + d2
  )
)

println( (1 to 100).aggregate(BigDecimal(0))((d, n) => d - n,(d1, d2) => d1 + d2) )
println( (1 to 100).par.aggregate(BigDecimal(0))((d, n) => d - n,(d1, d2) => d1 + d2) )

println( List(1,3,5,7).fold(0)((z, n) => z - n) )
println( List(1,3,5,7).par.fold(0)((z, n) => z - n) )
*/

/*
// 並列コレクション
// ((0-1)-2)-3
println( (1 to 10).fold(0)((z, n) => z - n) )
println( (1 to 10).par.fold(0)((z, n) => z - n) )
*/



/*
// fold
println(
  // ((0+1)+2)+3
  List(1,2,3).fold(0)((z, n) => z + n)
)

println(
  // 1+(2+(3+0))
  List(1,2,3).foldRight(0)((n,z)=> n + z)
)

println(
  // ((0-1)-2)-3
  List(1,2,3).fold(0)((z, n) => z - n)
)

println(
  // 1-(2-(3-0))
  List(1,2,3).foldRight(0)((n,z)=> n - z)
)
*/

/*
// convertをMapへ
def moto = Map(
  0->"RRR",
  5->"VVV"
)

def con(t:Int) = {
  moto.keys.find(n=>n==t).getOrElse("")
  
}

def conver(t:Int) = t match {
  case 0 => moto.get(t).get
  case 5 => moto.get(t).get
  case _  => ""
}

def check(c:String) = {
  moto.values.find(n=>n==c)
}

println( conver(0) )
println( conver(1) )
println( conver(5) )
println( conver(10) )

println( check("RRR") )
println( check("AAA") )
println( check("VVV") )

println( con(1) )
println( con(0) )
println( con(33) )
println( con(5) )
*/

/*
// enumをkvpで実現
val ek = Map(
  2->"SIN",
  3->"VID"
)

// あるとき
println(ek.values.find(n=>n=="SIN"))

// ないとき
println(ek.values.find(n=>n=="VON"))
*/



/*
// for の中でのif
println(
  for {
    b <- Seq(1,2,5,8,6,2134,3,4,7,9,21)
    if(b % 2 == 0) 
    c = b + 1
  } yield c
)
*/



/*
// Eitherとprojectionによるモナド
import scala.util.Random

def rndopt(deku:Option[String]):Option[String] = {
  return if(Random.nextBoolean) Some("some") else None
}

// rightの場合は処理継続。leftになったら返却される
println(
  rndopt(None).toRight("death").right.map{
    case "some"=> "righttt"
    case _ =>"deden"
  }
)

println(
  rndopt(None).toRight("death")
    .right.map{x=>rndopt(None).toRight("death")}
    .right.map{x=>rndopt(None).toRight("death")}
    .right.map{x=>rndopt(None).toRight("death")}
    .right.map{x=>rndopt(None).toRight("death")}
    .right.map{x=>rndopt(None).toRight("death")}
    .right.map{x=>rndopt(None).toRight("death")}
    .right.map{x=>rndopt(None).toRight("death")}
    .right.map{x=>rndopt(None).toRight("death")}
)

println(
  for {
    a <- Seq(1,3,2,6)
    b = a + 1
  } yield b
)

println(
  for {
    a <- Right(1).right
    b = a + 1
  } yield b
)

println(
  (for {
    a <- rndopt(Some("mone")).toRight("death").right
    b <- rndopt(Some(a)).toRight("deach2").right
  } yield b) match {
    case Left(x) => "left"
    case Right(x) => "right"
  }
)
*/



/*
// right left
import scala.util.Random

def rndopt:Option[String] = {
  return if(Random.nextBoolean) Some("some") else None
}

def retopt(str:String):Option[String] = {
  if(str == "some") return Some(str)
  return None
}

def retnone:Option[Any] = { return None }


println(
  retopt("some") match {
    case Some(s) => "sss"
    case None => "nnn"
  }
)

println(
  retopt("soe").toRight("nothing") match{
    case Right(x) => x + " rrr"
    case Left(x) => x + " lll"
  }
)

println( None.toRight("ss").right.map{identity} )

println(rndopt)
*/


/*
// headOption
println("proe".headOption)
println("".headOption)
*/

/*
// toRight OptionがSome(x)の場合はRight(x)に、Noneの場合、Left(left)に
println( Some(3).toRight("nai") )
println( None.toRight("nai") )

println( Some(3).toLeft("nai") )
println( None.toLeft("nai") )
*/

/*  
println(
  for {
    a <- Some(1).toRight(new Exception("None")).right
    b <- Right(3).right
  } yield a
)
*/


/*
// Either基本
def souda(x:Int):Either[Int,String] = {
  if (x%2==0)
  { Right("nasitoge") }
  else
  { Left(x) }
}

println(souda(1).left.get)
val l = souda(2)
println(l.right.get)

Seq(1,2,4,21,3,5,7,34,12,54).foreach{x=>souda(x) match {
    case Left(a) => println("L" + a)
    case Right(b) => println("R" + b)
  }
}
*/


/*
println(
  for {
    a <- Some(1)
    b <- Left(2).left.toOption
  } yield a
)

println(
  for {
    a <- Some(1).toRight(new Exception("None")).right
    b <- Right(2).right
  } yield a
)

println(
  for {
    a <- None.toRight(new Exception("None")).right
    b <- Right(2).right
  } yield a
)
*/

/*
// for ifを使った場合のfilter変換
println(
  for{
    a <- List(Some(1), None)
    if a.isDefined
  }yield a.get
)

println(
  List(Some(1), scala.None).withFilter(_.isDefined).map(a => a.get)
)
*/

/*
// for パターンマッチ
println(
  for{
    Some(a) <- List(Some(1), None)
  } yield a
)

println(
  List(Some(1), None).withFilter{
    case Some(a) => true
    case _ => false
  }.map{
    case Some(a) => a
    case _ =>
  }
)

println(
  List(Some(1), None).filter{n=>n!=None}.map(x=>x.get)
)

println(
  List(Some(1), None).withFilter{case n => n!=None}.map(x=>x.get)
)
*/

/*
// filterとwithFilterは実行順序が違う
val l = List(1,2,3,4)

// 中間状態のListが生成されない(なので高速)
l.withFilter( i => {
  println("fitler " + i)
  i % 2 == 0
}).map( i => {
  println("map " + i)
  i * 2
})

// 中間状態のListが生成される
l.filter( i => {
  println("fitler " + i)
  i % 2 == 0
}).map( i => {
  println("map " + i)
  i * 2
})
*/



/*
// withFilterは高速らしい
println(List(1,2,3,4,5).filter(n => n%2==1))
println(List(1,2,3,4,5).withFilter(n => n%2==1).map(identity))
*/


/*
// 式展開(s補完子ではStringBuilderが使われている)
val user = "giri"
val i = 2
println(s"No.${i + 1} is ${user}")
*/

/*
// 添え字
Seq("ffdsfd","zxcxcz","wee").zipWithIndex.foreach {case  (a,i)=>
  println(a +"asf"+ i)
}
*/



/*
// 内包表記
for {i <- 1 to 3
     j <- 1 to 3}
    println(i * j)


(1 to 3).foreach {
  case i => (1 to 3).foreach {
    case j => println(i * j)
  }
}

(1 to 3).foreach { i => 
  (1 to 3).foreach { j =>
    println(i * j)
  }
}
*/


/*
// ピリオドを省略するとwarningがでる
Seq(1, 2, 3).reverse
*/


/*
// 二重ループ
for (i <- 1 to 2;j <- 1 to 3) printf("%d-%d%n", i, j)

// セミコロン省略不可
for (i <- 1 to 2;
  j <- 1 to 3) printf("%d-%d%n", i, j)

// 波括弧にすると省略できる
for {i <- 1 to 2
  j <- 1 to 3} printf("%d-%d%n", i, j)

*/





/*
// 値を返却する yield
val res = for(i<-1 to 10) yield {i + 2}
println(res)

(for(i<-1 to 10) yield {i + 2}) map {println}
*/

/*
// forのフィルター(if)
for( i <- 1 to 10 if i % 2 == 0 ) println(i)

// and条件
for( i <- 1 to 10 if i % 2 == 0 ; if i % 3 == 0 ) println(i)

// 複数行の場合セミコロン不要
for( i <- 1 to 10
  if i % 2 == 0
  if i % 3 == 0 )
   println(i)
*/



/*
// 恒等関数
println( Seq(Seq(1,2,3), Seq(4), Seq(5, 6)).flatMap(identity) )
*/

/*
// Option型で処理を続けることができる
Seq(1,2,3,4) flatMap { x => 
  if(x % 2 == 0) Some(x) else None 
} map { x =>
  x * 2
} foreach { 
  println 
}

for {
  x <- Seq(1, 2, 3, 4) if x % 2 == 0
  y = x * 2
} println(y)
*/




/*
// flatten
println( Seq(Seq(1,2,3), Seq(4), Seq(5, 6)) flatMap { x => x } )
println( Seq(Seq(1,2,3), Seq(), Seq(5, 6)) flatMap { x => x } )
println( Seq(Seq(1,2,3), Seq(), Seq(5, 6)) flatten )
println( Seq(Seq(1,2,3), Seq(), Seq(5,6)) flatMap { x => 10 +: x } )

println( Seq(Seq(1,2,3), Seq(), Seq(5,6)) flatMap { x => Seq(x.size) } )
println( Seq(Seq(1,2,3), Seq(), Seq(5,6)) map { x => x.size } )

println( Seq(Seq("hello", "world"), Seq("good", "morning")) flatMap { x => Seq(x.mkString(" ").toUpperCase) } )
*/

/*
// 拡張メソッド
class UnitWrapper(i: Int) {
  def asFt = {
    i * 3.2808
  }

  def asM = {
    i * 0.30480
  }
  
  def plus(x:Int) ={ x + x }
  def +(x:Int) ={ x + x }
}

implicit def unitWrapper(i:Int) = new UnitWrapper(i)

println("1 foot = " + 1.asM + " meters");
println("1 meter = " + 1.asFt + "foot")

println( 1 plus 3 )
println( 1 + 3 )
*/



/*
// 逆順
println(9 to 0)
for (i <- 9 to 0 by -1) {
  println(i)
}

for(_ <- 1 to 3) println("zzz")
// for (val i <- 1 to 10) println(i)
*/


/*
// 繰り返し
for (i <- 1 to 10) println(i)
for (i <- Range(1,11)) println(i)
for (i <- Range(1,2,11)) println(i)
// for (i <- Range(1,2,10,11)) println(i)
// for (i <- Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) println(i)
println(Range(2,5))


for (i <- 1 until 10) println(i)

println(1 to 10)
println(1 until 10)
*/

/*
// for構文 パターンマッチ
val list = List(1->"o", 2->"t", 3->"t", 4->"f", 5->"f")

for ((n, "t") <- list) println(n)
for (t @ (_, "f") <- list) println(t)
*/


/*
// for構文 kvp
val map = Map(1 -> "one", 2 -> "two", 3 -> "three")

for ((k,v) <- map) printf("%d = %s%n", k, v)
for (t <- map) println(t.getClass)
for (t <- map) println(t._1 + " = " + t._2)
*/

/*
// for構文 tupleリスト
for ( (a,b) <- List((1,"one"),(2,"two"),(3,"three")) ){
  printf("%d = %s%n", a, b)
}
*/

/*
// for (変数 <- コレクション) 式
for (x <- Seq(1,3,4)) println(x)
for (x <- List(1,3,4)) println(x)

// for (変数 <- コレクション) { 式;… }
for (x <- Seq(1,3,4)){println(x)}
for (x <- List(1,3,4)){println(x)}
*/

/*
// split
val res = "sdfl,kjhs,dkjf,hsalfd".split(',')
val kara = "".split(',')

println(res)
println(kara)
*/

/*
// either型
def parseInt(s:String) : Either[Exception, Int] = {
  // 文字列がIntに変換できるならIntを、失敗した場合はExceptionを返す関数
  try Right(s.toInt) catch { case e:Exception => Left(e) } 
}

// rightを返す
println(parseInt("128"))
// leftを返す
println(parseInt("124A"))

// floatに変換
println( parseInt("49").right map { _.toFloat } )
// floatは実行されない
println( parseInt("ADF").right map { _.toFloat } )

// LeftをgetMessage
println( parseInt("ADF").left map { _.getMessage }  )
// getMessageは実行されない
println( parseInt("40").left map { _.getMessage } )
*/



/*
// 部分関数
val pf: PartialFunction[Int, String] = {
  case i if i%2 == 0 => "even"
}

val tf: (Int => String) = pf orElse { case _ => "odd"}


println( pf(2) )
println( tf(2) )
println( tf(3) )
*/

/*
// xml シリアライズデシリアライズ3
abstract case class Item() {
  val name: String
  val age: Int
  val isTarget: Boolean
  
  def toXML = 
<item isTarget={isTarget.toString} >
  <name>{name}</name>
  <age>{age}</age>
</item>
}

// シリアライズ
val item = new Item { 
  val name = "foo" 
  val age = 19 
  val isTarget = false 
}

val xml = item.toXML // <item isTarget="false"><name>foo</name><age>19</age></item>
println(xml)
*/


/*
// ガードによるチェック
List(1,2,3).map{
  case 1 => println("one")
  case n => println(n)
}
*/

/*
// 日付チェック
import java.text.SimpleDateFormat

val df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
df.setLenient(false)

println(df.parse("2014/12/12 12:12:12"))
try{
  println(df.parse("23098"))
}
catch { case e:Exception => None }
{
  println("ng")
}
*/

/*
// 数値チェック
println("109")
println("109".matches("""^\d+$"""))
println("d109")
println("d109".matches("""^\d+$"""))
println("1０9")
println("1０9".matches("""^\d+$"""))
*/

/*
val m = Map("kkk"->"vvv")
println(m)
println(m.get("kkk").mkString)
*/


/*
// MD5 scala的に
import java.security.MessageDigest
import java.text.MessageFormat
import java.net.URLEncoder

def createHash(src:String) ={
  val md = MessageDigest.getInstance("SHA-256")
  val hashBytes = md.digest( src.getBytes("UTF-8") )
  
  // ハッシュ値を16進文字列に変換
  var str = new StringBuilder("");
  for (hashByte <- hashBytes)
  {
    str.append(Integer.toHexString(0xFF & hashByte).toUpperCase());
  }
  
  str
}

def createHash2(src:String) ={
  val md = MessageDigest.getInstance("SHA-256")
  val hashBytes = md.digest( src.getBytes("UTF-8") )
  
  // ハッシュ値を16進文字列に変換
  var str = new StringBuilder("");
  for (hashByte <- hashBytes)
  {
    str.append(Integer.toHexString(0xFF & hashByte).toUpperCase());
  }
  
  
  val h = hashBytes.map{b=>Integer.toHexString(0xFF & b).toUpperCase()}.mkString
  println(h)
  println(h.getClass)

  val j = hashBytes.map{b=>Integer.toHexString(0xFF & b).toUpperCase()}.mkString.substring(5,10)
  println(j)
  println(j.getClass)
  
  str.substring(5, 5 + 5)
}

def createHash3(src:String) ={
  MessageDigest.getInstance("SHA-256").digest( src.getBytes("UTF-8") ).map{b=>Integer.toHexString(0xFF & b).toUpperCase()}.mkString.substring(5,10)
}

println(createHash("hash"))
println(createHash2("hash"))
println(createHash3("hash"))
println(MessageDigest.getInstance("SHA-256").digest( "hash".getBytes("UTF-8") ).map{b=>Integer.toHexString(0xFF & b).toUpperCase()}.mkString.substring(5,10))
*/

/*
// MD5
import java.security.MessageDigest
import java.text.MessageFormat
import java.net.URLEncoder

def createHash(src:String) ={
  //md5 =  require("crypto").createHash 'SHA256'
  //md5.update src, 'utf8'
  //md5.digest('hex').substr(5,5).toUpperCase()
  val md = MessageDigest.getInstance("SHA-256")
  val hashBytes = md.digest( src.getBytes("UTF-8") )
  
  // ハッシュ値を16進文字列に変換
  var str = new StringBuilder("");
  for (hashByte <- hashBytes)
  {
    str.append(Integer.toHexString(0xFF & hashByte).toUpperCase());
  }
  
  str.substring(5, 5 + 5);
}
*/


/*
// idの配列それぞれに情報を紐づける3
case class res(
  id: Long,
  str: String
)

val lres = Seq(res(30215809L, "dondon"),res(60230461L, "nini"))
val params = Seq(30215809L, 30216321L, 60230461L, 30216321L)

val tuita = params.map {i =>
  lres.find(_.id == i) match {
    case Some(v) => i + v.str
    case None => "nai"
  }
}

println(tuita)
*/


/*
// 発見したら終了
val cf = List(1,2,3).collectFirst{
  case 2 =>
    println("aa")
    "two" 
  case _ =>
    println("nisni")
    "nai"

}
println(cf)
*/


/*
// idの配列それぞれに情報を紐づける2 NG
case class res(
  id: Long,
  str: String
)

val lres = Seq(res(30215809L, "dondon"),res(60230461L, "nini"))
//println(lres)
//lres.map{i=>println(i.id)}
//lres.foreach{i=>println(i)}
val params = Seq(30215809L, 30216321L, 60230461L, 30216321L)

val tuita = params.map {i =>
  lres.map{j=>
    j.id match {
      case i => Map(i-> "atta")
      case _ => "nochint"
    }
  }
}

println(tuita)

lres.map{i=>
  i.id match {
    case 30215809L => println(i + "aaa")
    case _ => println(i)
  }
}
*/



/*
// idの配列それぞれに情報を紐づける
val params = Seq(30215809L, 30216321L, 60230461L, 30216321L)
val info = Map(30216321L -> "porepre")
//println( info.get(30216321L) )
//println( info.get(30216321L).mkString )
//println( info.get(30216300L) )
//println( info.contains(30216321L) )
//println( info.contains(30216300L) )

val tuita = params.map {i =>
  if(info.contains(i))
  {
    Map(i -> info.get(30216321L).mkString)
  }
  else
  {
    "nothing"
  }
}

println(tuita)
*/

/*
// Symbol
println('aoija)
println('aoija.getClass)
*/



/*
// どちらのモジュールを使うか外部の設定で分岐させる
import java.io.File
import scala.io.Source

// val l = Source.fromFile(new File("config.txt")).getLines.toArray
// println( l(0) )

val a = try {Source.fromFile(new File("config.txt")).getLines.toArray.apply(0) } catch { case e:Exception => None }
println( a )

val res = a match {
  case "hell" => "jigoku"
  case "death" => "siiii"
  case _  => "nothing"
}

println(res)
*/



/*
case object Ccc {
  val aa = 1
  val bb = 2
}

object Ooo {
  val aa = 3
  val bb = 4
}

// toStringが実装されている
println(Ccc)
println(Ooo)

println(Ccc.aa)
println(Ooo.aa)
*/

/*
// case abstract いろいろなメソッドを追加してくれる
abstract case class acc()

case class Bom(id:String,code:Int)
class Dom(id:String,code:Int)


val bom = new Bom("bbbb",0)
val dom = new Dom("ddd",3)

// コンストラクタとフィールドが定義される
println(bom.id) // 実はメソッド呼び出し
// println(dom.id)

// toStringも自動で実装
println(bom)
println(bom.code.getClass)

// copy(一部を変えたインスタンスの作成)
val bomnext = bom.copy(code = 2)
println(bomnext)


// applyによりnewがいらない
val bom2 = Bom("bbbb2",0)
// val dom2 = Dom("ddd",3)

println(bom2.id)
//  println(dom2.id)

// パターンマッチ(unapplyが定義されている)
val lBom = List(Bom("asadf",34),Bom("fdsf",432),Bom("fefefz",2134))
val list = lBom collect {case Bom(n, 34)=>n}
println(list)
*/


/*
// xml シリアライズデシリアライズ2 case objectでもいけるっぽい
abstract class Item {
  val name: String
  val age: Int
  val isTarget: Boolean
  
  def toXML = <item isTarget={isTarget.toString} ><name>{name}</name><age>{age}</age></item>
}

// シリアライズ
val item = new Item { 
  val name = "foo" 
  val age = 19 
  val isTarget = false 
}

val xml = item.toXML // <item isTarget="false"><name>foo</name><age>19</age></item>
println(xml)

case object Item {
  def fromXML(node: scala.xml.Node): Item = new Item
  {
    val name = (node \ "name").text
    val age = (node \ "age").text.toInt
    val isTarget = (node \ "@isTarget").text.toBoolean
  }
}

// デシリアライズ
val item2 = Item.fromXML(<item isTarget="false"><name>foo</name><age>19</age></item>)
println(item2.toXML)
println(item2.name)
println(item2.age)
println(item2.isTarget)

val item3 = Item.fromXML(xml)
println(item3.toXML)
*/




/*
// xml シリアライズデシリアライズ
abstract class Item {
  val name: String
  val age: Int
  val isTarget: Boolean
  
  def toXML = <item isTarget={isTarget.toString} ><name>{name}</name><age>{age}</age></item>
}

// シリアライズ
val item = new Item { 
  val name = "foo" 
  val age = 19 
  val isTarget = false 
}

val xml = item.toXML // <item isTarget="false"><name>foo</name><age>19</age></item>
println(xml)

object Item {
  def fromXML(node: scala.xml.Node): Item = new Item
  {
    val name = (node \ "name").text
    val age = (node \ "age").text.toInt
    val isTarget = (node \ "@isTarget").text.toBoolean
  }
}

// デシリアライズ
val item2 = Item.fromXML(<item isTarget="false"><name>foo</name><age>19</age></item>)
println(item2.toXML)
println(item2.name)
println(item2.age)
println(item2.isTarget)

val item3 = Item.fromXML(xml)
println(item3.toXML)
*/

/*
// xmlのパターンマッチ
val item = <item isTarget="false" ><name>foo</name><age>19</age></item>
item match {
  case <item><name>{name}</name><age>{age}</age></item> => println(name) // foo
  case _ =>
}

item match {
  case <item><name>{name}</name>{unused @ _*}</item> => println(name) // foo
  case _ =>
}

item match {
  case <item>{elements @ _*}</item> => {
    elements foreach {
      el => println(el.text) // "foo" "19"
    }
  }
  case _ =>
}

val items =
<items>
  <item isTarget="false" ><name>foo</name><age>19</age></item>
  <item isTarget="true" ><name>bar</name><age>24</age></item>
</items>

for ( <item>{elements @ _*}</item> <- items \ "item" ) {
  elements foreach {
    el => println(el.text) // "foo" "19" "bar" "24"
  }
}
*/



/*
// xmlファイル出力
import scala.xml.XML
val xml = 
<root>
  <items>
    <item isTarget="false" ><name>foo</name><age>19</age></item>
    <item isTarget="true" ><name>bar</name><age>24</age></item>
  </items>
</root>
XML.save("items.xml", xml, "UTF-8", true, null)
*/


/*
// xmlロード
import scala.xml.XML
println(XML.loadFile("items.xml"))
*/

/*
// enumurationの利用
object WeekDay extends Enumeration {
  type WeekDay = Value
  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
}
import WeekDay._

def isWorkingDay(d: WeekDay) = ! (d == Sat || d == Sun)

println(isWorkingDay(Mon))
println(isWorkingDay(Sat))
// println(isWorkingDay(Death))
*/

/*
// ファイル一覧
import java.io.File

new File(".").listFiles.foreach(println)
*/



/*
// sqlファイル読み込み
import java.io.File
import scala.io.Source

val r = new File("sql.sql")
println(r)
val s = Source.fromFile(r)
s.getLines.foreach(println)

//ワンライナー
Source.fromFile(new File("sql.sql")).getLines.foreach(println)
*/

/*
// longに変換
println("2")
println("2".getClass)
println("2".toInt)
println("2".toInt.getClass)
println("2".toLong)
println("2".toLong.getClass)
*/

/*
// 配列をseqに格納
val str = "123,1232,3222"
val arr = str split ','
println(arr)
arr.foreach{i=>
  println(i)
}

val l = arr.map{i=>
  i
}

l.map{i=>println(i)}
println(l)

// println(Seq(123,32,12))
*/


/*
// デフォルト引数
def defau(aaa: String = "nanigasi") {
  println(aaa)
}

defau()
defau("renren")

def niban(aaa: String = "nibanme", bbb: String = "hutatume") {
  println(aaa)
  println(bbb)
}

niban()
niban("bonbon")
niban("denden","daiko")
niban(bbb = "daiko")

*/


/*
// yield
val listItems = List("Scala","Java","Ruby")

val resList = for(item <- listItems) yield "bon" + item
println(resList)

println(for(item <- listItems) yield "ben" + item)

for(item <- listItems) yield {println("bun" + item)}

val bin = for(item <- listItems) yield {
  "bin" + item
  "nasi"
}
println(bin)
*/


/*
// for フィルタリング
val listItems = List("Scala","Java","Ruby")

for (
item <- listItems // ジェネレータ
if item.length == 4 // フィルタ
) {
  println(item)
  println(item)
}
*/


/*
// for ←
val listItems = List("Scala","Java","Ruby")
 
for(item <- listItems) println("item = " + item)
for(item ← listItems) println("item = " + item)
*/



/*
// if は最後に評価された値を返却する
val x = 0
val res = if(x == 0) "zerooo" else "not"

println(res)

val y = 1
//val els = if(y == 0) "zerooo" else "not"
val els = if(y == 0) "zerooo"

println(els)
*/


/*
// タプル配列
def rettup = {
  ( ("fdd"->"sdfd"),
    ("key"->"koma") )
}

println( rettup._1 )
*/



/*
// タプルを返却
def rettup = {
  ("fdd","sdfd")
}

println( rettup._2 )
*/



/*
// タプル 22個まで指定できる
println( ("asno") )
println( ("asno").getClass )
println( ("asno",8) )
println( ("asno",8).getClass )
println( ("asno","asdfd",1) )
println( ("asno","asdf",1).getClass )
println( ("asno","asdf",1)._1 )
println( ("asno"->"asdfd",1) )
println( ("asno"->"asdfd",1).getClass )
println( ("asno"->"asdfd",1)._1.getClass )
*/



/*
// immutable追加 Map
val map1 = Map("kkkk" -> "vvv","kkkk2" -> "vvv2")
val map2 = map1 + ("keyekey"->"ddfd")
println(map1)
println(map2 - "kkkk")
println(map2)

// List
println(Nil)
println(("keyekey"->"ddfd") :: Nil)
*/




/*
// immutable追加 Set
val list1 = Set("398")
val list2 = list1 + "34"
val list3 = list2 + "34"
println(list1)
println(list2)
println(list3)
*/


/*
// immutable追加 Seq
val list1 = Seq(398)
val list2 = 99 +: list1
val list3 = list2 :+ "8989"
println(list1)
println(list2)
println(list3)
*/


/*
// immutable追加 List
val list1 = List(398)
val list2 = 99 :: list1
val list3 = 989 :: list2
println(list1)
println(list2)
println(list3)

val x = List("soijd",2)
println(x)

val y:List[String] = List("soijd","2",9.toString)
println(y)

val lBuild = Nil
val l2 = "ichi"::lBuild
val l3 = "ni"::l2
val l4 = "san"::l3
println(lBuild)
println(l4)
println(l4.head)
println(l4.tail)
println(l4.isEmpty)
println(l4.length)
*/


/*
// Scala Map foreach
val map = Map("kkkk" -> "vvv","kkkk2" -> "vvv2")
map.foreach{ kv =>
  val (k,v) = kv
  println(k + ":" + v)
}

map.foreach{ case(k,v) =>
  ///val (k,v) = kv
  println(k + ":" + v)
}

for ( (k,v)<-map ) {
  println(k + ":" + v)
}

println(map.keys)
println(map.keySet)
println(map.keysIterator)

println(map.values)
println(map.valuesIterator)
println(map.map{kv=> kv.getClass})
*/

/*
// Scala Map
println(Map)
println(Map.getClass)

val rM = scala.collection.mutable.Map("bon"->"asdf")
rM.put("var","varrr")
val lM = Map
println(rM)
println(lM)

println(Map.empty)
println(scala.collection.immutable.Map)
println(scala.collection.immutable.HashMap)
println(scala.collection.immutable.TreeMap)
println(scala.collection.immutable.IntMap)
println(scala.collection.immutable.LongMap)
println(scala.collection.immutable.ListMap)

println(scala.collection.mutable.Map)
println(scala.collection.mutable.HashMap)
println(scala.collection.mutable.LinkedHashMap)
println(scala.collection.mutable.WeakHashMap)
println(scala.collection.mutable.ListMap)
//println(scala.collection.mutable.SynchronizedMap)
//println(scala.collection.mutable.ConcurrentMap)
println(scala.collection.concurrent.TrieMap)
*/


/*
// 文字列-> timestamp
import java.text.SimpleDateFormat
import java.sql.Timestamp

val df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
df.setLenient(false)
val date = "2014/12/25 17:37:30"
println( df.parse(date).getTime() )
println( df.parse(date).getTime().getClass )
println( new Timestamp(df.parse(date).getTime()) )
*/


/*
// 文字列->日付
import java.text.SimpleDateFormat
import java.util.Date

val df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
df.setLenient(false)
val date = "2014/12/25 17:37:30"
println(df.parse(date))
println(df.parse(date).getClass)
println( "%tY/%<tm/%<td %<tH:%<tM:%<tS" format df.parse(date) )
println( ("%tY/%<tm/%<td %<tH:%<tM:%<tS" format df.parse(date)).getClass )
*/


/*
// 今日を取得2
import java.util.Date
println( "%tY/%<tm/%<td" format new Date )
println( "%tF" format new Date )
println( "%tY/%<tm/%<td %<tH:%<tM:%<tS" format new Date )
println( new Date )
println( (new Date).getClass )
println( (new Date).toString )
println( (new Date).toString.getClass )
*/

/*
// 今日を取得 YYYY/MM/DD HH24:MI:SS
import java.text.SimpleDateFormat
import java.sql.Timestamp

//val now = java.util.Calendar.getInstance()
//println( now.get(java.util.Calendar.YEAR) )
//println(System.currentTimeMillis())

val date = "2014/12/25 17:37:30"
val df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
df.setLenient(false)
println(df.parse(date).getClass)

val tsnow = new Timestamp(System.currentTimeMillis())
println(System.currentTimeMillis().getClass)
println( tsnow.getTime().getClass )
println( tsnow.getClass )

val tsvof = "2014-12-25 17:37:30.12345678"
println( Timestamp.valueOf(tsvof) )

val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

println(sdf.format( tsnow ).getClass)
println(df.format( tsnow ).getClass)
println(df.format( System.currentTimeMillis() ).getClass)
println(df.format( new Timestamp(System.currentTimeMillis()) ).getClass)
println( tsnow.getClass )
println( tsnow.toString.getClass )
println(Timestamp.valueOf( tsnow.toString ).getClass)
println(Timestamp.valueOf( sdf.format(tsnow) ).getClass)
*/



/*
// foreach
Array(1,2,3,4,5) foreach {
  println(_)
}

// map
val l = Array(1,2,3,4,5) map {
  _*2
}

l foreach{println(_)}
println(l.toString)


// filter
Array(1,2,3,4,5) filter{
  _ == 3
} foreach { e => 
  println(e)
}


// match
3 match {
  case 3 => println("san")
  case _ => println("hoka")
}
*/



/*
// pipeline
val fil = (n:Int)=>  { 
  true
}

def pl( n:Int ) = { 
  1 to n
} filter {
  fil
} map {
  case n if n  == 1 => "ichi"
  case n if n  == 2 => "ni"
  case n if n  == 3 => "san"
  case n            => n.toString 
} foreach { e => 
  println( e )
}

// pl(5)
//println( {1 to 3} filter{fil} match { case _ => } map{ e => e})
{1 to 3
} filter {fil
} map { e => e
} match { case a => println(a)}
//} foreach {b=>println(b) }
*/



/*
// yammer is scara2java for
var start = System.currentTimeMillis();

val loop = 2147483647
var total = 0;
for(i <- 0 until loop) { 
  total += i 
};

var end = System.currentTimeMillis();
println(end-start);
println(total);

start = System.currentTimeMillis();
total = 0;
var i = 0;
while(i < loop) { 
  total += i
  i=i+1;
};

end = System.currentTimeMillis();
println(end-start);
println(total);
*/


/*
def fizzbuzz( n:Int ) = { 
  // 「リストを作る」
  1 to n
} filter {
  // 「合成したり、条件に合わせて絞り込む」
  n => n % 2 == 0
} map {
  // 「個々の要素を加工する」
  case n if n % 15 == 0 => "FizzBuzz"
  case n if n % 3  == 0 => "Fizz"
  case n if n % 5  == 0 => "Buzz"
  case n                => n.toString 
} foreach { e => 
  // 「個々の要素を利用した操作を行う」
  println( e )
}

fizzbuzz(10)
*/


/*
// 数値のmatch
val i = 3
i match {
  case 1 => println("i is 1")
  case 2 => println("i is 2")
  case 3 => println("i is 3")
}
 
97 match {
  case 'a' => println("match 'a'") //'a'は数値にすると97なので、ここにマッチする。
  case 'b' => println("match 'b'")
  case 'c' => println("match 'c'")
}
*/



/*
// ガード節による値変換6 (リテラルで)
val convert: (Int) => String = {
  case 1 => "ichi"
  case 2 => "ni"
  case 3 => "san"
  case 4 => "shi"
  case _ => "death"
}

println(convert(2))
println(convert(4))
println(convert(3))
println(convert(5))
*/

/*
// ガード節による値変換5 (省略系)
val convert = {
  case 1 => "ichi"
  case 2 => "ni"
  case 3 => "san"
  case 4 => "shi"
  case _ => "death"
}:( (Any) => Any )

println(convert(2))
println(convert(4))
println(convert(3))
println(convert(5))
*/

/*
// ガード節による値変換4 (省略系)
val convert: (Any) => Any = {
  case 1 => "ichi"
  case 2 => "ni"
  case 3 => "san"
  case 4 => "shi"
  case _ => "death"
}

println(convert(2))
println(convert(4))
println(convert(3))
println(convert(5))
*/


/*
// ガード節による値変換3 (省略系)
var convert:(Any)=>Any=null

convert = {
  //_ match {
    case 1 => "ichi"
    case 2 => "ni"
    case 3 => "san"
    case 4 => "shi"
    case _ => "death"
  }

println(convert(2))
println(convert(4))
println(convert(3))
println(convert(5))
*/


/*
// ガード節による値変換2 (省略系) これを採用
def convert(t:Int) = t match {
  case 1 => "ichi"
  case 2 => "ni"
  case 3 => "san"
  case 4 => "shi"
  case _ => "death"
}

println(convert(2))
println(convert(4))
println(convert(3))
println(convert(5))
*/


/*
// ガード条件 if
def know(c: Class[_]) = {
  c match {
    case x if x==classOf[String] => "文字列"
    case x if x==classOf[Int]    => "整数"
    case _                       => "他"
  }
}

println(know("saf".getClass))
println(know(true.getClass))
println(know(1.getClass))
println(know(0.1.getClass))
*/

/*
// ガード節による値変換(match式)
def convert(t:Int):String = {
  t match {
    case 1 => "ichi"
    case 2 => "ni"
    case 3 => "san"
    case 4 => "shi"
    case _ => "death"
  }
}

println(convert(2))
println(convert(4))
println(convert(3))
println(convert(5))
*/



/*
// 型のマッチング
def know(a: Any) = {
  a match {
    case _: String => "文字列"
    case _: Int    => "整数"
    case _         => "他"
  }
}

println(know("saf"))
println(know(true))
println(know(1))
println(know(0.1))
*/

/*
// xml 追加
val getXml = (value:String)=> {
  val xml =
  <root>
    <vall>
      {value}
    </vall>
  </root>
  xml
}

val xml = <root><bon>kure</bon>
{getXml("anoktar")}
  </root>
println(xml.toString)
*/


/*
// xmlを返却する関数化
val getXml = (value:String)=> {
  val xml =
  <root>
    <vall>
      {value}
    </vall>
  </root>
  xml
}

println(getXml("bababa"))
*/


/*
// xmlの出力
val name = "world"
val x = <s>hello,{name}</s>
val n = <s>{ 123 + 456 }</s>

println(x.getClass)
println(n.getClass)

val s ="""
  <root>
    <bon/>
  </root>
"""

import scala.xml.XML
val ls = XML.loadString(s)

println(ls.getClass)
*/

/*
// xmlの作成2
val xml = <parent>
  <child id="a">A</child>
  <children>
    <child id="b">B</child>
  </children>
  <child id="c">C</child>
</parent>

// \関数：直下の子要素を抽出
println(xml \ "child")

// \\関数：再帰的に子要素を抽出
println(xml \\ "child")

// 連結して書ける
println(xml \ "children" \ "child")

// @指定:属性の値を取得
println(xml \\ "@id")
val ns = xml \\ "@id"
ns.foreach{i=>println(i.getClass)}

// すべての要素を指定
(xml \\ "_").foreach(e => println(e.label.getClass))
*/

/*
// xmlの作成
import scala.xml.XML
val ls = XML.loadString("<parent><child>a</child><child>b</child></parent>")

import java.net.URL
val l = XML.load(new URL(""))

println("death")
println(ls.getClass)
println(l.getClass)

// コード上に書いてもElemがとれる
val xml = <parent><child>a</child><child>b</child></parent>
println(xml)
println(xml.getClass)
*/


/*
// stream 2
def from(n:Int):Stream[Int] = Stream.cons( n, from(n+1) )
println(from(0).filter(x => x<10 ).take(10).length)
*/

/*
// stream
def from(n:Int):Stream[Int] = Stream.cons( n, from(n+1) )

val infs = from(0)

val filts = infs.filter(x => x<10 )

val takes = filts.take(10)

println(takes.length)
*/


/*
// val s:(String) => Unit =(a:String) => {println(a)}

// コードブロックの中括弧{}を省略
//val s:(String) => Unit =(a:String) => println(a)

// 思い切って関数の型を省略
// val s =(a:String) => {println(a)}

// s("prin")

// 引数なしの関数はこれ
val s:() => Unit = () => println("bon")
s()
*/

/*
// 関数リテラルの書き方
// Stringを引数に取りUnitを返す
(s: String) => {}: Unit
(s: String) => {}

// Stringを引数に取りStringを返す
(s: String) => {""}: String
(s: String) => {""}
(s: String) => ""

// Intの引数を２つ取り和を返す
(x: Int, y: Int) => x + y

// メソッドに関数リテラルを渡す
def fnc1(f: Int => Int): Int = {f(1)}

fnc1((n: Int) => n + 1)

// メソッド側に型の定義があるので省略できる
fnc1(n => n + 1)

// プレースホルダーを使う
fnc1(_ + 1)

val fun =(s:String)=> {println(s)}
fun("sdf")
*/


/*
// def 関数名(変数名:型): 戻り値の型 = {}
def add1(x: Int, y: Int): Int = {x + y}

// 戻り値の型は省略できる
def add2(x: Int, y: Int) = {x + y}
def add3(x: Int, y: Int) = x + y

// ＝も省略（{}が必要）
def add4(x: Int, y: Int) {x + y}

// 戻り値がない関数定義
def out1(s: String): Unit = {println(s)}
def out2(s: String) = println(s)
def out3(s: String) {println(s)}

// 関数を引数に取る関数
def fnc1(f: Int => Int): Int = {f(1)}
def fnc2(f: (Int, String) => Int): Int = {f(1, "2")}

// 引数の無い関数
def noArgs1() {}
def noArgs2 {}

// 関数を返す関数
def retFnc1(): String => String = (s: String) => "return " + s

val kansu = retFnc1()
println(kansu("this"))
*/

/*
// lazy val はJVM上ではメソッドとして定義される
class MyClass {
  def hoge1: Int = {
    val x = 1
    lazy val y = 1
    x + y
  }

  def hoge2: Int = {
    val x = 1
    lazy val y = 1
    x + y
  }
}
*/

/*
// => はJVM上では関数オブジェクト
class MyTest {
  def hoge1(x: Int) = x + 1
  def hoge2(x: => Int) = x + 1
  def hoge3(x: () => Int) = x() + 1
}
*/


/*
// defの定義で、引数なしと空括弧は微妙に違う
def func1 = (_: Int) + 1
def func2() = (_: Int) + 1

// 引数無しで定義すると"func1()"では呼び出せない
println(func1)
// println(func1())

// 空括弧で定義すると"func2()"でも"func2"でも呼び出せる
println(func2)
println(func2())

// func1は括弧付きで呼び出せないので、意図したように解釈される
func1(5)

// func2を5を引数として呼び出したと解釈されるため、エラーとなる
// func2(5)
func2()(5)
*/

/*
// メソッドと関数型のフィールドは違う
// 名前付き引数で呼べる
def hoge(x: String): Int = x.length
println(hoge("abcde"))  // ←一見同じ振る舞いをするように見える
println(hoge(x = "abcde"))

// 名前付き引数で呼べない
def huga: String => Int = x => x.length
println(huga("abcde"))  // ←一見同じ振る舞いをするように見える

// hoge(x = "abcde")

// 引数には自動的に名前がつく (コメント欄参照)
println(huga(v1 = "abcde"))

// 後者はfunctionオブジェクトを返す
class MyTest {
  def hoge1(x: String): Int = x.length
  def hoge2: String => Int = x => x.length
}
*/



/*
object ValVarDef {
  val x = 1
  var y = 2
  def z = 3
}

println(ValVarDef.x)
println(ValVarDef.y)
println(ValVarDef.z)
*/

/*
// def val
def func(a:String):(String)=a

println(func("yuda"))
// println(func)

val vanc = (a:String) => a
println(vanc("yuda"))
println(vanc)
*/


/*
// apply
val ooo = (s:String)=>{println(s)}
ooo.apply("ei")
ooo("mem")


object obu {
  val aaa= (e:String)=>{println(e)}
  // def apply = (e:String)=>{println(e+"kari")}
  val apply = (e:String)=>{println(e+"ote")}
}

obu.aaa("isu")
obu.apply.apply("isu")
*/

/*
// コンパニオンオブジェクトは関数
case class A(n: Int)

val f: Int => A = A

println(f(1))
*/

/*
// アクセスできない
class B {
  def method(n: Int) = A.method(n)
 
  private val a = 1
}
 
object A {
  private def method(n: Int) = n * 2
 
  val i = {
    val a = new B
    a.a
  }
}

println(A.i)
*/


/*
class companion{
  val vvv = "saf"
  def ooo = ()=>{println("class")}
  def func(n:String):String = {n + "claaa"}
  def apply():companion ={new companion()}
// def clasu ={companion().vvv}
  def clasu ={companion.vvv}
}

object companion {
  val vvv = "jijij"
  def ooo = ()=>{println("object")}
  def func(n:String):String = {n + "obuuuuu"}
  def claaa = ()=>{
    val nai = new companion()
    println(nai.clasu)
  }
  def apply():companion ={new companion()}
}

companion.claaa()
*/

/*
println(companion.func("rin"))
println(companion().func("rin"))
println(new companion().func("rin"))
println(companion.func(""))
*/

/*
def func(n:String):String = {
  n
}

println(func("rin"))
*/

/*
class companion{
  val vvv = "saf"
  def ooo = ()=>{println("class")}
  def apply():companion ={return new companion()}
}

object companion {
  val vvv = "jijij"
  def ooo = ()=>{println("object")}
  
  def apply():companion ={return new companion()}
}

val c = new companion()
c.ooo()
companion.ooo()

println(c.vvv)
println(companion.vvv)

val a = companion.apply()
a.ooo()
println(a.vvv)

val b = companion()
b.ooo()
println(b.vvv)

println(companion.vvv)
println(companion().vvv)

println(companion.ooo())
println(companion().ooo())

println(companion.ooo)
*/



// val d = companion.ttt()

// companion("compa")


/*
// Action解析
object Tree {
  def pre = {(str:String)=>
    println("module!")
  }
  
  def apply = ()=>{
    println("apply!")
  }
}


// def in = Tree.apply("bom")
//def in = Tree("bom")
//in

// Tree.apply("bom")
// Tree("bom")
Tree.apply()
// Tree()

// in.pre("nanika")
*/


/*
// 65536
val kasi = (a:Int)=> println(a + a)
(1 to 10).foreach{i=>kasi(i)}
*/


/*
// 遅延評価
def message(str: String): String = {
  println("Called!")
  str + "!"
}
lazy val str = message("World")
val str2 = message("hell")
println("Before lazy val...")
println(str)
println(str2)
*/

/*
// クロージャ
object CounterFactory
{
  def create(): (Int) => Int =
  {
    var i = 0
    (j:Int) =>
    {
      i += j
      i
    }
  }
}

val c1 = CounterFactory.create()
println(c1(1)) // 1
println(c1(1)) // 2
val c2 = CounterFactory.create()
println(c2(2)) // 2
println(c2(2)) // 4
*/


/*
// 関数3
val kaki = (a:String)=>a
println( kaki("kaki")  )

def unini(s:String) : Unit = println(s)

unini("nitani")

val p = (str: String) => println(str)
val repeat = (printer: (String) => Unit, times: Int) => {
  (str: String) => 1 to times foreach ( _ => printer(str) )
}
val twice_p = repeat(p,2)
twice_p("test")

List(3,2,4,6,1,5).sortWith({ (a,b) => a < b }).foreach({ (n) => println(n*n) })
List(3,2,4,6,1,5) sortWith { (a, b) => a < b } foreach { n => println(n*n) }
List(3,2,4,6,1,5) sortWith(_<_) foreach { n => println(n*n) } 
*/


/*
// 関数2
def add(a:Int,b:Int) = {a+b}
val add2= {(a:Int,b:Int) => a + b}
val add3:Int=>Int=>Int = {a => b => a + b}

println(add(2,3))
println(add2(2,3))
println(add3(2)(3))

val add4 = (a:Int,b:Int) => a + b
println(add4(2,3))
*/


/*
// 関数
def fact(n:Int):Int = {
  if (n == 1) {1} else {(n * fact(n-1))}
}

println(fact(4))

def chie(a:String):String = "modori" + a

println(chie("hiki"))
*/

/*
// RxJava
import rx.lang.scala.Observable

object tmp {

def hello(names: String*) {
  Observable.from(names) subscribe { n =>
    println(s"Hello $n!")
  }
}


def main(args: Array[String]): Unit = {
  println("asfs")
  hello("Ben", "George")
}}

*/

/*
// receive
import akka.actor
import akka.actor._
import java.util.concurrent.TimeUnit

class master extends Actor {
  def receive = {
    case x =>
    {
      println("maindesu")
      //TimeUnit.MILLISECONDS.sleep(1000)
      //sender ! "res"
      sender ! 1
      //self ! 1
    }
  }
}

implicit val as = ActorSystem.create

val rootInbox = ActorDSL.inbox()

//val m = as.actorOf( Props(new master()) )

val f = 10

println("sending")
(0 to f).foreach{i=>
  val m = as.actorOf( Props(new master()) )
  rootInbox.send(m, "main")
}

println("receiven")
(0 to f).foreach{i=>
  println("rere:" + rootInbox.receive())
}
println("downer")

//m ! "main"
as.shutdown
*/



/*
// sender
import akka.actor
import akka.actor._
import java.util.concurrent.TimeUnit

class master extends Actor {
  var task = 0
  var done = 0
  
  def receive = {
    case "main" =>
      println("maindesu")
      sender ! "sub"
    case "sub" =>
      println("subdesu")
      //as.shutdown
  }
}

implicit val as = ActorSystem.create
val m = as.actorOf( Props(new master()) )
val rootInbox = ActorDSL.inbox()
rootInbox.send(m, "main")
TimeUnit.MILLISECONDS.sleep(1000)
println("rere:" + rootInbox.receive())
TimeUnit.MILLISECONDS.sleep(1000)

rootInbox.send(m, "sub")
TimeUnit.MILLISECONDS.sleep(1000)
println("rere:" + rootInbox.receive())
TimeUnit.MILLISECONDS.sleep(1000)

//m ! "main"
as.shutdown
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
