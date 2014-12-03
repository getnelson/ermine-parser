scalacOptions += "-deprecation"

resolvers += Resolver.url(
  "bintray-sbt-plugin-releases",
  url("http://dl.bintray.com/content/sbt/sbt-plugin-releases"))(
    Resolver.ivyStylePatterns)

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
