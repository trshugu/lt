// URIチェック
package checklinkmodule

import java.net.URL
import java.net.HttpURLConnection
import sun.net.www.protocol.https.HttpsURLConnectionImpl

object CheckLinkModule {
  def check_uri(uri: String):String = {
    try
    {
      val url = new URL(uri)
      val conn = url.openConnection().asInstanceOf[HttpURLConnection]
      //conn.setInstanceFollowRedirects(false)
      
      conn.getResponseCode() match
      {
        case HttpURLConnection.HTTP_OK =>
          //return uri + " " + conn.getResponseCode() + "\n"
          return ""
        case HttpURLConnection.HTTP_MOVED_PERM |
             HttpURLConnection.HTTP_MOVED_TEMP =>
          return uri + " " + conn.getResponseCode() + "\n"
        case _ =>
          return uri + " " + conn.getResponseCode() + "\n"
      }
    }
    catch
    {
      case e: Exception =>
        println(e)
        return uri + " 例外\n"
    }
    
  }
}

