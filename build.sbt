name := "parser"

organization in Global := "io.verizon.ermine"

crossScalaVersions in Global := Seq("2.12.4", "2.11.12", "2.10.7")

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

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.4")

javacOptions += "-Xlint"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.0.0-RC1",
  "org.scalaz" %% "scalaz-core" % scalazVersion.value,
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion.value % "test"
)

initialCommands in console := "import scalaz._, Scalaz._; import scalaparsers._"
