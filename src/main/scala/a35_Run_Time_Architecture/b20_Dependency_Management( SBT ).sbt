
/*
	cat project/assembly.sbt
		addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.11.2")
	sbt assembly
	# In the target directory, we'll see an assembly JAR
	ls target/scala-2.10/
		my-project-assembly.jar
	# Listing the assembly JAR will reveal classes from dependency libraries
	jar tf target/scala-2.10/my-project-assembly.jar
		...
		joptsimple/HelpFormatter.class
	# An assembly JAR can be passed directly to spark-submit
	/path/to/spark/bin/spark-submit --master local ...
		target/scala-2.10/my-project-assembly.jar				
 */
import AssemblyKeys._
name := "Simple Project"
version := "1.0"
organization := "com.databricks"
scalaVersion := "2.10.3"
libraryDependencies ++= Seq(
// Spark dependency
"org.apache.spark" % "spark-core_2.10" % "1.3.0" % "provided",
// Third-party libraries
"net.sf.jopt-simple" % "jopt-simple" % "4.3",
"joda-time" % "joda-time" % "2.0"
)
// This statement includes the assembly plug-in capabilities
assemblySettings
// Configure JAR used with the assembly plug-in
jarName in assembly := "my-project-assembly.jar"
// A special option to exclude Scala itself from our assembly JAR, since Spark
// already bundles Scala.
assemblyOption in assembly :=
(assemblyOption in assembly).value.copy(includeScala = false)      