package com.bitscott.bigdata.cats

import cats.Semigroup
import cats.implicits._

object SemigroupApp extends App {
	
	//  https://www.scala-exercises.org/cats/semigroup
	Semigroup[Int].combine(1, 2) // 3
	Semigroup[List[Int]].combine(List(1, 2, 3), List(4, 5, 6)) // List(1, 2, 3, 4, 5, 6)
	Semigroup[Option[Int]].combine(Option(1), Option(2)) // Option(3)
	Semigroup[Option[Int]].combine(Option(1), None) // Some(1)
	Semigroup[Int => Int].combine(_ + 1, _ * 10).apply(6) // 67
	
	//   Map(foo -> Map(bar -> 11), baz -> Map())
	Map("foo" -> Map("bar" -> 5)).combine(Map("foo" -> Map("bar" -> 6), "baz" -> Map()))
	//   Map(foo -> List(1, 2, 3, 4), bar -> List(42))
	Map("foo" -> List(1, 2)).combine(Map("foo" -> List(3, 4), "bar" -> List(42)))
	
	//  Map(foo -> Map(bar -> 6), baz -> Map())
	Map("foo" -> Map("bar" -> 5)) ++ Map("foo" -> Map("bar" -> 6), "baz" -> Map())
	//  Map(foo -> List(3, 4), bar -> List(42))
	Map("foo" -> List(1, 2)) ++ Map("foo" -> List(3, 4), "bar" -> List(42))
	
	val aMap = Map("foo" -> Map("bar" -> 5))
	val anotherMap = Map("foo" -> Map("bar" -> 6))
	
	val combinedMap = Semigroup[Map[String, Map[String, Int]]].combine(aMap, anotherMap)
	//  println(combinedMap.get("foo"))
	
	val one: Option[Int] = Option(1)
	val two: Option[Int] = Option(2)
	val n: Option[Int] = None
	one |+| two // Some(3)
	n |+| two // Some(2)
	n |+| n // None
	two |+| n // two
}
