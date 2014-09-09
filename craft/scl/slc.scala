import checklinkmodule._
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
//import java.util._
import scala.io.Source
import java.util.concurrent.TimeUnit;

object slc { def main(args: Array[String]): Unit = {

// logger作成
val log = new FileWriter("log.txt", true)
log.write("hell...\n")

// テキストを読み込む
if (args.length != 1) {
  log.write("argv nothing")
  sys.exit()
}

val file = args(0)

val f = new File(file)
if(f.exists == false) sys.exit()

// 結果ファイル名(同じファイル名が存在していたら削除)
val resultfile = "zzresult_" + file
val r = new File(resultfile)
if (r.exists) r.delete

// uriを抽出しリストに格納
var urllist = new collection.mutable.ListBuffer[String]

val s = Source.fromFile(f)
val reg = "^http".r

try {
  s.getLines.foreach { line => 
    if ( reg.findFirstIn(line) == Some("http") ) {
      urllist.append(line.trim)
    }
  }
} finally{
  s.close
}

// 無視リスト対応
Source.fromFile("ignore.txt").getLines.foreach{line=>
  urllist = urllist.filterNot( i=> i==line )
}

// 総件数
val result = new FileWriter(resultfile,true)
result.write(urllist.size + "件\n")

// -----------------------------------------------------------------------------
// URIチェック
// -----------------------------------------------------------------------------
// 計測開始
val starttime = System.currentTimeMillis();

// チェック
urllist.foreach { uri =>
  val checked_uri = CheckLinkModule.check_uri(uri)
  result.write(checked_uri)
}


// 計測終了
result.close
val endtime = System.currentTimeMillis();
println("done " + (endtime - starttime))
log.write((endtime - starttime) + "\n")
log.close
}}



