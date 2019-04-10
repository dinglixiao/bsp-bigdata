package com.bitscott.cats

import cats.Apply
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
}