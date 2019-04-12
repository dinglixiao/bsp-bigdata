package com.bitscott.bigdata.cats

import cats.implicits._

object OptionApp extends App {
	
	2.some //	res0: Option[Int] = Some(2)
	none[Int] // res0: Option[Int] = None
	Some("hello").orEmpty // res0: String = "hello"
	none[String].orEmpty // res0: String = ""
	
	def even(i: Int) = (i % 2 == 0).guard[Option].as("even")
	
	//	println(even(2))
	//	println(even(3))
	
	
}
