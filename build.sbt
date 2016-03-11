
lazy val root = (project in file(".")). 
  settings(
    name := "sparkexperiments",
    version := "1.0",  
    // Scal Version
    scalaVersion := "2.10.4",
    // Download source code(will come in handy to refer the code in eclipse)
    EclipseKeys.withSource := true,
    libraryDependencies ++= Seq(
    	//'provided' - We do not want to ship these JARs to
    	//             worker nodes, as they will be already available
        //             in the worked nodes
    	"org.apache.spark" % "spark-core_2.10" % "1.5.2" % "provided"
    )
 )
