package com.bitscott.cats

import cats.Applicative
import cats.implicits._

object ApplicativeApp extends App {
	
	//	Some(1)
	Applicative[Option].pure(1)
	//	List(1)
	Applicative[List].pure(1)
	
	val f: (Int, Char) => Double = (i, c) => (i + c).toDouble
	val int: Option[Int] = Some(5)
	val char: Option[Char] = Some('a')
	//	println(int.map(i => (c: Char) => f(i, c)))
}
