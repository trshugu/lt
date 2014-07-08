package hell

import org.scalatra._
import scalate.ScalateSupport

class sanzu extends ScaperStack {

  get("/") {
    <html>
      <body>
        <h1>Hell, world!</h1>
        Say <a href="hello-scalate">hell to Scalat</a>.
      </body>
    </html>
  }
  
}
