package a12_Actions

import org.apache.spark.rdd.RDD

class Append(val suffix: String) {
  
  def appendSuffixBad(inputRDD: RDD[String]): RDD[String] = {
     // Bad      As we are referring the Member variable
     //           the whole object will be serialized & transferred
     //           to the Executor(so that 'suffix' can be referred
     inputRDD.map { x => x + suffix }             
  }
  
  def appendSuffixGood(inputRDD: RDD[String]): RDD[String] = {
     // Good      Here we copied the Member variable 'suffix' into a 
     //           local variable, so only the local variable is transferred
     //           to the executor
     val localsuffix = suffix;
     inputRDD.map { x => x + localsuffix }             
  }

}