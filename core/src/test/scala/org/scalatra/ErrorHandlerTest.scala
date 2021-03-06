package org.scalatra

import test.scalatest.ScalatraFunSuite

class ErrorHandlerTestServlet extends ScalatraServlet {
  get("/") {
    throw new RuntimeException
  }

  error {
    "handled " + caughtThrowable.getClass.getName
  }
}

class ErrorHandlerTest extends ScalatraFunSuite {
  addServlet(classOf[ErrorHandlerTestServlet], "/*")

  test("result of error handler should be rendered") {
    get("/") {
      body should equal ("handled java.lang.RuntimeException")
    }
  }

  test("response status should be set to 500 on error") {
    get("/") {
      status should equal (500)
    }
  }
}