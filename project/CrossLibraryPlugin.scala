package verizon.build

import sbt._, Keys._

object CrossLibraryPlugin extends AutoPlugin {

  object autoImport {
    val scalazVersion = settingKey[String]("scalaz version")
  }

  import autoImport._

  override def trigger = allRequirements

  override def requires = RigPlugin

  override lazy val projectSettings = Seq(
    scalazVersion := {
      sys.env.get("SCALAZ_VERSION").getOrElse("7.2.7")
    },
    // unmanagedSourceDirectories in Compile += (sourceDirectory in Compile).value / s"scalaz-stream-${scalazStreamVersion.value.take(3)}",
    version := {
      val suffix = if(scalazVersion.value.startsWith("7.2")) "" else "a"
      val versionValue = version.value
      if(versionValue.endsWith("-SNAPSHOT"))
        versionValue.replaceAll("-SNAPSHOT", s"$suffix-SNAPSHOT")
      else s"$versionValue$suffix"
    }
  )
}
