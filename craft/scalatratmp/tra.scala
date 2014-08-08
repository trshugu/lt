import org.scalatra._

object tra extends ScalatraServlet {
  get("/") {
    <h1>Hello, world!</h1>
  }
}