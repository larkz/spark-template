package etl

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.ml.linalg.{DenseVector, SparseVector, Vectors}
import org.apache.spark.sql.functions.udf

trait ExtendableTrait extends Serializable {
  val spark = SparkSession.builder().getOrCreate()
  import spark.implicits._
}