package com.knoldus

import com.typesafe.config.ConfigFactory

import java.util.Properties
import javax.mail._
import javax.mail.internet.{InternetAddress, MimeMessage}

class SMTPService {

  val config = ConfigFactory.load()

  private val host = config.getString("smtp.hostname")
  private val user = config.getString("smtp.userid")
  private val password = config.getString("smtp.password")
  private val recipient = "kuldeepak.gupta@knoldus.com"
  val properties = new Properties()
  properties.put("mail.smtp.host", host)
  properties.put("mail.smtp.auth", "true")


  def testEmail: Option[String] = {
    val subject = Email.subject
    val body = Email.emailBody
    println("Sending Emails")
    sendEmail(subject, body)
  }

  def sendEmail(subject: String, body: String): Option[String] = {
    val session = Session.getDefaultInstance(properties, new Authenticator() {
      override protected def getPasswordAuthentication = new PasswordAuthentication(user, password)
    })

    println(s"Session Started with ${session}")
    try {
      val message = new MimeMessage(session);
      message.setFrom(new InternetAddress(user));
      message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
      message.setSubject(subject);
      message.setText(body);

      println(s"Ready to send Message ${message}")
      Transport.send(message);

      println("message sent successfully...")
      Some("Message Sent")

    } catch{
      case e: MessagingException =>
        println(e.getMessage)
        e.printStackTrace()
        None
    }
  }
}
