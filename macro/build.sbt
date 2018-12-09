ThisBuild / name := "macros-test"
ThisBuild / organization := "com.github.snorochevskiy"
ThisBuild / version := "1.0.0"

scalaVersion in ThisBuild := "2.12.8"

// Macro methods should be defined in separate module
lazy val macros = (project in file("macros")).settings(
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion.value
  )
)

lazy val app = (project in file("app")).dependsOn(macros)
.settings(
  mainClass in (Compile, run) := Some("demo.usemacro.MacrosTestApp")
)
