package com.example.app
import org.scalatra._

class HelloWorldApp extends ScalatraFilter {
  get("/") {
    <h1>Hello, {params("name")}</h1>
  }
}
