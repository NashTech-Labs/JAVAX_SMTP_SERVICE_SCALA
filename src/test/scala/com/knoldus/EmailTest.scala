package com.knoldus

import org.scalatest.flatspec.AsyncFlatSpec

class EmailTest extends AsyncFlatSpec {

  "email subject" should " return " in {
    assert(Email.subject.nonEmpty)
  }

  "email body" should " return " in {
    assert(Email.emailBody.nonEmpty)
  }

}
