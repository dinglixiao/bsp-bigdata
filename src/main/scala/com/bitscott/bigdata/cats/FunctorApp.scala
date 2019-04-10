package com.bitscott.cats

import cats.implicits._

/**
	* map
	*/
object FunctorApp extends App {
	
	//	Some(2)
	Option(1).map(_ + 1)
	//	List(2, 3, 4)
	List(1, 2, 3).map(_ + 1)
	//	Vector(1, 2, 3)
	Vector(1, 2, 3).map(_.toString)
	
	//	List((Cats,4), (is,2), (awesome,7))
	List("Cats", "is", "awesome").fproduct(_.length)
	//	List(Some(2), Some(1), Some(4))
	List(Some(1), None, Some(3)).map(_.combine(1.some))
	//	List(Some(2), Some(1), Some(4))
	List(Some(1), None, Some(3)).map(_ |+| 1.some)
	//	List(Some(1), None, Some(3))
	List(Some(1), None, Some(3)).map(_.combineN(1))
}
