name := "parser"

organization in Global := "io.verizon.ermine"

crossScalaVersions in Global := Seq("2.12.1", "2.11.8", "2.10.6")

scalaVersion in Global := crossScalaVersions.value.head

description := "A Trifecta inspired parser in Scala."

licenses += ("BSD Simplified", url("https://github.com/verizon/ermine-parser/blob/master/LICENSE"))

homepage := Some(url("https://github.com/verizon/ermine-parser"))

scalacOptions ++=
  Seq("-encoding", "UTF-8", "-Yrecursion", "50", "-deprecation",
      "-unchecked", "-Xlint", "-feature",
      "-language:implicitConversions", "-language:higherKinds",
      "-language:existentials", "-language:postfixOps")

resolvers += Resolver.bintrayRepo("non", "maven") // for kind-projector

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")

javacOptions += "-Xlint"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % scalazVersion.value,
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion.value % "test"
)

initialCommands in console := "import scalaz._, Scalaz._; import scalaparsers._"
