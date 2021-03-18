package etl

import org.apache.spark.sql.{DataFrame, SparkSession}

import org.apache.spark.sql.functions._
import org.apache.log4j.Logger

class SampleClass(aggMethodStr: String = "gma") extends Serializable with ExtendableTrait {
    @transient lazy val logger: Logger = Logger.getLogger(getClass.getName)

    override val spark = SparkSession.builder().getOrCreate()
    import spark.implicits._

    def sampleMethod(arg1: String): String = {
        print("cool")
        "done!"
    }

}