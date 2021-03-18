package main

import etl.SampleClass
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.log4j.Logger

class MainClass extends Serializable {
  @transient lazy val logger: Logger = Logger.getLogger(getClass.getName)
}

object MainClass extends Serializable {

  def main(args: Array[String]): Unit = {

    println("Feature Ingest Main Routine: ")
    val dummy = args(0)
    dummy match {
      case "sampleclass" => sampleMainMethod(args(1))
      case _ => throw new ClassNotFoundException(s"$dummy entry key does not exist !")
    }
  }

  def sampleMainMethod(arg1: String): String = {
    val sClass = new SampleClass()
    sClass.sampleMethod(arg1)
  }
}


