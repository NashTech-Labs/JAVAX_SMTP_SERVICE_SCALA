package com.knoldus

object Application extends App {

  val service = new SMTPService
  service.testEmail
  Thread.sleep(5000)

}
