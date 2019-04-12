package com.bitscott.bigdata.cats

import cats.implicits._

object EitherApp extends App {
	
	2.asRight[String] // res0: Either[String,Int] = Right(2)
	"err".asLeft[Int] // res0: Either[String,Int] = Left("err")
	
	"err".asLeft[Int].leftMap(new Exception(_)) // res0: Either[Exception,Int]
	"err".asLeft[Int].leftFlatMap(err => Left(new Exception(err))) // res0: Either[Exception,Int]
	"err".asLeft[Int].bimap(err => new Exception(err), v => v.toLong) // res0: Either[Exception, Long]
	
	val e: Either[String, List[Int]] = Right(List(1, 2, 3))
	e.ensure("Must be non-empty")(_.nonEmpty) // Right(List(1, 2, 3))
	e.ensure("Must be non-empty")(_.size > 10) // Left(Must be non-empty)
	
	val l: List[Either[String, Int]] = List(Right(1), Left("error"))
	//	val (ls: List[String], rs: List[Int]) = l.separate
	
	val x: List[Option[Int]] = List(Some(1), Some(2))
	val y: List[Option[Int]] = List(None, Some(2))
	//	println(s"x.sequence = ${x.sequence}")
	
	def parseInt(s: String): Option[Int] = Either.catchOnly[NumberFormatException](s.toInt).toOption
	
	val res = List("1", "2", "3").traverse(parseInt)
	//	println(s"result = ${res}")
	
	val xv: List[Vector[Int]] = List(Vector(1, 2), Vector(3, 4))
	//	println(s"xv.unite = ${xv.unite}")
	
	println((Option(1) -> Option("john")).getClass)
}
