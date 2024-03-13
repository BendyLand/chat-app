val scala3Version = "3.3.1"

mainClass in Compile := Some("Main")

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,
    
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
    
    scalacOptions ++= Seq("-deprecation")
  )

lazy val client = project.in(file("client"))
lazy val server = project.in(file("server"))
