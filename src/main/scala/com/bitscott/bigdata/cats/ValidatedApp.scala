package com.bitscott.bigdata.cats

import cats._
import cats.implicits._

object ValidatedApp extends App {
	
	//	Valid(1)
	1.valid
	//	Invalid(1)
	1.invalid
	//	Valid(1)
	1.validNel
	//	Invalid(NonEmptyList(1))
	1.invalidNel
	//	Some(a)
	Some("a")
	val s = "a".some
	
	val success1 = "a".asRight[Int]
	val success2 = "b".asRight[Int]
	
	val failure = 400.asLeft[String]
}
