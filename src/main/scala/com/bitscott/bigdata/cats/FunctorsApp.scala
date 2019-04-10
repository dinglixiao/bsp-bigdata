package com.bitscott.cats

import cats._
import cats.instances.all._
import cats.syntax.functor._

object FunctorsApp extends App {
	
	val len: String => Int = _.length
	val lenList = Functor[List].map(List("scala", "cats"))(len)
	println(lenList)
	
	val r: Either[String, Int] = Right(100)
	val rMap = r.map(x => x + 1)
	println(rMap)
	
	val len2: String => Int = _.length
	val len2List = List("scala", "cats").fproduct(len)
	println(len2List)
	println(len2List.toMap)
}
