package com.bitscott.cats

import cats.Apply
import cats.data.Validated
import cats.data.Validated.{Invalid, Valid}
import cats.implicits._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object ApplyApp extends App {
	
	
	val intToString: Int ⇒ String = _.toString
	val addOne: Int ⇒ Int = _ + 1
	val addTwo: Int ⇒ Int = _ + 2
	
	//	List(2, 3, 4)
	Apply[List].ap(List(addOne))(List(1, 2, 3))
	//	List(2, 3, 4, 3, 4, 5)
	Apply[List].ap(List(addOne, addTwo))(List(1, 2, 3))
	//	Some(5)
	Apply[Option].ap(Some(addOne))(Some(4))
	//	Some(6)
	(addOne).some ap 5.some
	//	None
	(addOne).some ap None
	//	List(2, 3, 5)
	List(addOne) ap List(1, 2, 4)
	println()
	
	val addBoth = (a: Int, b: Int) ⇒ a + b
	//	println((addBoth).some ap2(3.some, 5.some))
	//	println()
	
	def ff(a: Future[Int], b: Future[Int]) = (a |@| b).map(_ + _)
	
	//	println((5.some, 6.some, 2.some).mapN(_ + _ + _))
	//	println(1.show)
	
	
	type ErrOr[A] = Validated[String, A]
	
	val validInt: ErrOr[Int] = Valid(3)
	val validBool: ErrOr[Boolean] = Valid(true)
	val invalidInt: ErrOr[Int] = Invalid("Invalid int.")
	val invalidBool: ErrOr[Boolean] = Invalid("Invalid boolean.")
	
	//	println(Apply[ErrOr].productL(validInt)(validBool))
	//	println(Apply[ErrOr].productR(validInt)(validBool))
	//	println(Apply[ErrOr].productR(validInt)(invalidBool))
	//	println(Apply[ErrOr].productR(invalidInt)(invalidBool))
	
	//	println(validInt.productL(validBool))
	
	println((List(1, 2), List(3, 4), List(0, 2)).mapN(_ * _ * _))
}