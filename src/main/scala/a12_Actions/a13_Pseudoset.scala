package a12_Actions

import org.apache.spark.SparkContext

object a13_Pseudoset {
  val sc = new SparkContext();
  
  //Reference : Learning Spark (Page 38)
  val rdd1 = sc.parallelize(List("lion", "tiger", "tiger", "peacock", "horse"))
  val rdd2 = sc.parallelize(List("lion", "tiger"))
  
  // distinct()	: Returns distinct element in the RDD
  // Warning 		:	Involves shuffling of data over N/W
  rdd1.distinct().collect()
  
  // union() 	: Returns an RDD containing data from both sources
  // Note 		: Unlike the Mathematical Union, duplicates are	
  //            not removed
  rdd1.union(rdd2).collect()
  
   // intersection() :  Returns elements that are common b/w both
   //                   RDDs. Also removed Duplicates
   // Warning				 :	Involves shuffling & has worst performance
  rdd1.intersection(rdd2).collect();
  
  // subtract()			:		Returns only elements that are present in the
  //                    first RDD
  rdd1.subtract(rdd2).collect()
  
   // cartesian()	: Provides cartesian product b/w 2 RDDs
   // Warning			:	Is very expensive for large RDDs
  rdd1.cartesian(rdd2).collect();
  
  
}

/*
scala>   //Reference : Learning Spark (Page 38)

scala>   val rdd1 = sc.parallelize(List("lion", "tiger", "tiger", "peacock", "horse"))
rdd1: org.apache.spark.rdd.RDD[String] = ParallelCollectionRDD[33] at parallelize at <console>:21

scala>   val rdd2 = sc.parallelize(List("lion", "tiger"))
rdd2: org.apache.spark.rdd.RDD[String] = ParallelCollectionRDD[34] at parallelize at <console>:21

scala>
     |   // distinct(): Returns distinct element in the RDD

scala>   // Warning ::Involves shuffling of data over N/W

scala>   rdd1.distinct().collect()
res20: Array[String] = Array(peacock, lion, horse, tiger)

scala>
     |   // union() : Returns an RDD containing data from both sources

scala>   // Note : Unlike the Mathematical Union, duplicates are

scala>   //            not removed

scala>   rdd1.union(rdd2).collect()
res22: Array[String] = Array(lion, tiger, tiger, peacock, horse, lion, tiger)

scala>
     |    // intersection() :  Returns elements that are common b/w both

scala>    //                   RDDs. Also removed Duplicates

scala>    // Warning ::Involves shuffling & has worst performance

scala>   rdd1.intersection(rdd2).collect();
res24: Array[String] = Array(lion, tiger)

scala>
     |   // subtract():Returns only elements that are present in the

scala>   //                    first RDD

scala>   rdd1.subtract(rdd2).collect()
res26: Array[String] = Array(peacock, horse)

scala>
     |    // cartesian(): Provides cartesian product b/w 2 RDDs

scala>    // Warning:Is very expensive for large RDDs

scala>   rdd1.cartesian(rdd2).collect();
res28: Array[(String, String)] = Array((lion,lion), (lion,tiger), (tiger,lion), (tiger,tiger), (tiger,lion), (tiger,tiger), (peacock,lion), (peacock,tiger), (horse,lion), (horse,tiger))

*/
