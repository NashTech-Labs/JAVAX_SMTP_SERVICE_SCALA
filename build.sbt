ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "javax-smtp-implementation"
  )

libraryDependencies ++= Seq("com.sun.mail" % "javax.mail" % "1.6.2",
  "org.scalatest" %% "scalatest" % "3.2.12" % Test,
  "org.mockito" % "mockito-all" % "1.10.19" % Test,
  "com.typesafe" % "config" % "1.4.1"
)

