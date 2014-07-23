/*
*/
/*
object tmp {
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

println("asdf")

val svc = url("http://yahoo.co.jp")
val country = Http(svc OK as.String)

println("end")
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
