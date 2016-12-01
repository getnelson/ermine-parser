package verizon.build

import sbt._, Keys._
import xerial.sbt.Sonatype.autoImport.sonatypeProfileName

object CentralRequirementsPlugin extends AutoPlugin {

  override def trigger = allRequirements

  override def requires = RigPlugin

  override lazy val projectSettings = Seq(
    sonatypeProfileName := "io.verizon",
    pomExtra in Global := {
      <developers>
        <developer>
          <id>joshcough</id>
          <name>Josh Cough</name>
          <url>https://github.com/joshcough</url>
        </developer>
        <developer>
          <id>PipocaQuemada</id>
          <name>PipocaQuemada</name>
          <url>https://github.com/PipocaQuemada</url>
        </developer>
        <developer>
          <id>S11001001</id>
          <name>Stephen Compall</name>
          <url>https://github.com/S11001001</url>
        </developer>
        <developer>
          <id>timperrett</id>
          <name>Timothy Perrett</name>
          <url>http://github.com/timperrett</url>
        </developer>
        <developer>
          <id>runarorama</id>
          <name>Runar Bjarnason</name>
          <url>http://github.com/runarorama</url>
        </developer>
        <developer>
          <id>stew</id>
          <name>Stew O'Connor</name>
          <url>http://github.com/stew</url>
        </developer>
        <developer>
          <id>SethTisue</id>
          <name>Seth Tisue</name>
          <url>https://github.com/SethTisue</url>
        </developer>
      </developers>
    },
    licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.html")),
    homepage := Some(url("http://verizon.github.io/knobs/")),
    scmInfo := Some(ScmInfo(url("https://github.com/verizon/knobs"),
                                "git@github.com:verizon/knobs.git"))
  )
}
