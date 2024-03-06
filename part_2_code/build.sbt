val scala3Version = "3.4.0"

lazy val root = project
  .in(file("."))
  .settings(
    
    name := "Part_2_Code",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,

    //Allow using the brics dependancy
    libraryDependencies += "dk.brics" % "automaton" % "1.12-4"
  )
