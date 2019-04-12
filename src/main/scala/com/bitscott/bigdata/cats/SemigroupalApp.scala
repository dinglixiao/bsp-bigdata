package com.bitscott.bigdata.cats

import cats.Semigroupal
import cats.implicits._

object SemigroupalApp extends App {
	
	val noneInt: Option[Int] = None
	val some3: Option[Int] = Some(3)
	val noneString: Option[String] = None
	val someFoo: Option[String] = Some("foo")
	
	//	res0: Option[(Int, String)] = None
	Semigroupal[Option].product(noneInt, noneString)
	//	res1: Option[(Int, String)] = None
	Semigroupal[Option].product(noneInt, someFoo)
	//	res2: Option[(Int, String)] = None
	Semigroupal[Option].product(some3, noneString)
	//	res3: Option[(Int, String)] = Some((3,foo))
	Semigroupal[Option].product(some3, someFoo)
	
	println(Semigroupal[Option].product(noneInt, noneString))
}
