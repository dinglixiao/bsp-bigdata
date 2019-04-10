package com.bitscott.bigdata.cats

import cats.implicits._
import cats.kernel.Monoid

object MonoidApp extends App {
	
	Monoid[String].empty // ""
	Monoid[String].combineAll(List("a", "b", "c")) // abc
	Monoid[String].combineAll(List()) // ""
	
	//  Map(b -> 2, a -> 4)
	Monoid[Map[String, Int]].combineAll(List(Map("a" → 1, "b" → 2), Map("a" → 3)))
	//  Map()
	Monoid[Map[String, Int]].combineAll(List())
	
	val l = List(1, 2, 3, 4, 5)
	//  15
	l.foldMap(identity)
	//  12345
	l.foldMap(i ⇒ i.toString)
}