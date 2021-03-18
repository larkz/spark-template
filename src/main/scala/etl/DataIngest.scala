package etl

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.log4j.Logger

class DataIngest extends Serializable with ExtendableTrait {

  @transient lazy val logger: Logger = Logger.getLogger(getClass.getName)

  override val spark = SparkSession.builder().getOrCreate()
  import spark.implicits._

  // Ingest .parquet
  def getParquet(parquetPath: String): DataFrame = {
    println("read parquet!")
    spark.read.parquet(parquetPath)
  }

  // write file to csv
  def writeToCSV(df: DataFrame, fileName: String): Unit = {
    println("writing dataframe to csv!")
    df.write.format("com.databricks.spark.csv").option("header", "true").save(fileName)
  }

  // Ingest Databricks delta
  def getDelta(deltaPath: String): DataFrame = {
    println("read delta!")
    spark.read.format("delta").load(deltaPath)
  }

  // Ingest bigQuery
  def getBigQuery(tableName: String, projectId: String, credentialsFilePath: String): DataFrame = {
    spark.read.format("bigquery")
      .option("credentialsFile", credentialsFilePath)
      .option("project", projectId)
      .option("table", tableName).load()
  }
}
