package a12_Actions;

import org.apache.spark.SparkContext

object Collect {
  val sc = new SparkContext()
  val inputRDD = sc.parallelize(1 to 10)
  //Filter number '5'
  val filteredRDD = inputRDD.filter(x => x != 5)
  
  //Collect all the records
  //Warning : This will collect the entire data in RDD
  //          into local machine memory
  filteredRDD.collect()
  
  //Collect only 2 records from the RDD into Local Machine meory
  filteredRDD.take(2)
  
  filteredRDD.saveAsTextFile("./result.txt")
}

/*
scala>   val inputRDD = sc.parallelize(1 to 10)
inputRDD: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[7] at parallelize at <console>:21

scala>   //Filter number '5'

scala>   val filteredRDD = inputRDD.filter(x => x != 5)
filteredRDD: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[8] at filter at <console>:23

scala>
     |   //Collect all the records

scala>   //Warning : This will collect the entire data in RDD

scala>   //          into local machine memory

scala>   filteredRDD.collect()
res12: Array[Int] = Array(1, 2, 3, 4, 6, 7, 8, 9, 10)

scala>
     |   //Collect only 2 records from the RDD into Local Machine meory

scala>   filteredRDD.take(2)
res14: Array[Int] = Array(1, 2)
*/