scalaVersion := "2.12.10"
// scalaVersion := "2.12.8"


name := "WordCountGenerator"
organization := "ch.epfl.scala"
version := "1.0"



libraryDependencies ++= Seq(
        "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
        "org.apache.kafka" % "kafka-clients" % "3.0.0"
    )

assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}
assemblyJarName in assembly := "test_kafka.jar"