name := "scala-parsers"

organization in Global := "oncue.ermine"

crossScalaVersions := Seq("2.11.6", "2.10.5")

scalaVersion := crossScalaVersions.value.head

description := "A Trifecta inspired parser in Scala."

licenses += ("BSD Simplified", url("https://github.com/ermine-language/ermine-parser/blob/master/LICENSE"))

homepage := Some(url("https://github.com/ermine-language/ermine-parser"))

publishMavenStyle := true

scalacOptions ++=
  Seq("-encoding", "UTF-8", "-Yrecursion", "50", "-deprecation",
      "-unchecked", "-Xlint", "-feature",
      "-language:implicitConversions", "-language:higherKinds",
      "-language:existentials", "-language:postfixOps")

resolvers += "bintray/non" at "http://dl.bintray.com/non/maven"

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.5.2")

parallelExecution := true

javacOptions += "-Xlint"

val scalazVersion = "7.1.2"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % scalazVersion,
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion % "test"
)

initialCommands in console := "import scalaz._, Scalaz._; import scalaparsers._"

publishTo <<= version.apply(v => {
  val nexus = "http://nexus.svc.oncue.com/nexus/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "content/repositories/thirdparty")
 })

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
