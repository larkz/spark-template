name := "scala-repo-template"

version := "1.0.0"

// scalaVersion := "2.11.8"
scalaVersion := "2.12.2"

val sparkVersion = "3.0.1"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion, // % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion, // % "provided",
  "org.apache.spark" %% "spark-mllib" % sparkVersion, // % "provided",
  "com.databricks" % "dbutils-api_2.11" % "0.0.4",
  "io.spray" %% "spray-json" % "1.3.3",
  "com.typesafe" % "config" % "1.2.1"
  // "org.apache.logging.log4j" % "log4j-api" % "2.14.0",
  // "org.apache.logging.log4j" % "log4j-core" % "2.14.0"
  // "com.typesafe.play" %% "play" % "2.7.1"
)
// libraryDependencies += "com.exasol" % "exasol-jdbc" % "6.2.3"

resolvers += Classpaths.typesafeReleases

mainClass in(Compile, run) := Some("main.MainClass")
mainClass in(Compile, packageBin) := Some("main.MainClass")

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

