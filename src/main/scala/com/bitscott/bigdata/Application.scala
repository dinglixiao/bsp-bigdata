package com.bitscott

import org.apache.spark.SparkConf
import org.apache.spark.internal.Logging
import org.apache.spark.sql.SparkSession

object Application extends App with Logging {

  val conf = new SparkConf().setAppName("bsp-spark").setMaster("local[2]")
  val spark = SparkSession.builder().config(conf).getOrCreate()

  case class CargoType(code: String, name: String, createDate: String, weight: Int) {}

  val cargoTypes = Seq(
    CargoType("0", "电子产品", "2018-09-17 15:01:01", 45),
    CargoType("92", "商品汽车", "2018-09-17 15:05:05", 12),
    CargoType("93", "冷藏货物", "2018-09-17 15:08:10", 46),
    CargoType("94", "大宗货物", "2018-09-17 15:15:15", 32),
    CargoType("95", "快速消费品", "2018-09-17 15:20:20", 47),
    CargoType("96", "农产品", "2018-09-17 15:33:25", 15),
    CargoType("999", "其他", "2018-09-17 15:35:30", 84)
  )

  import spark.implicits._
  val cargoDF = cargoTypes.toDF()

  cargoDF.show(1000, false)
}
