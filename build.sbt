version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .settings(
    name := "Java-Scala",
    libraryDependencies += "org.junit.jupiter" % "junit-jupiter" % "5.13.4" % Test
  )
