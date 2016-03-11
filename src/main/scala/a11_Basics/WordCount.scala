package sbook.helloworld

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.rdd.PairRDDFunctions

/**
 * @author mountain
 */
object WordCount {
   def main(args: Array[String]) {

      println("In main : " + args(0) + "," + args(1))

      //Create Spark Context
      val conf = new SparkConf().setAppName("WordCountApp")
      val sc = new SparkContext(conf)

      //Load Data from File
      val input = sc.textFile(args(0))

      //Split into words
      val words = input.flatMap(line => line.split(" "))

      //Assign unit to each word
      val units = words.map ( word => (word, 1) )

      //Reduce each key
      val counts = units.reduceByKey ( (x, y) => x + y )

      //Write output to Disk
      counts.saveAsTextFile(args(1))
      sc.stop();
   }
}
