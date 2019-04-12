package com.bitscott.bigdata.cats

import cats._
import cats.implicits._

object FoldableApp extends App {
	
	//	6
	Foldable[List].foldLeft(List(1, 2, 3), 0)(_ + _)
	//	abc
	Foldable[List].foldLeft(List("a", "b", "c"), "")(_ + _)
	//	6
	//	List(1, 2, 3).foldLeft(0)(_ + _)
	
	//	3
	Foldable[List].foldMap(List("a", "b", "c"))(_.length)
	//	123
	Foldable[List].foldMap(List(1, 2, 3))(_.toString)
	
	
	Foldable[List].foldK(List(List(1, 2), List(3, 4, 5)))
	Foldable[List].foldK(List(None, Option("two"), Option("three")))
	
	Foldable[List].find(List(1, 2, 3))(_ > 2)
	Foldable[List].find(List(1, 2, 3))(_ > 5)
	
	Foldable[List].exists(List(1, 2, 3))(_ > 2)
	Foldable[List].exists(List(1, 2, 3))(_ > 5)
	
	Foldable[List].forall(List(1, 2, 3))(_ <= 3)
	Foldable[List].forall(List(1, 2, 3))(_ < 3)
	
	Foldable[List].toList(List(1, 2, 3))
	Foldable[Option].toList(Option(42))
	Foldable[Option].toList(None)
	
	
}
