val scala3Version = "3.4.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "CS474 Project 2",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
  
    //allow use of brics library
    libraryDependencies += "dk.brics" % "automaton" % "1.12-4"

  )
