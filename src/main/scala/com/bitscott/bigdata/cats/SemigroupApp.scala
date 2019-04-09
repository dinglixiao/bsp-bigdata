package com.bitscott.cats

import cats.Semigroup
import cats.implicits._

object SemigroupApp extends App {

  //  println(1.|+|(1))
  //  println(1.combine(1))
  //  println(Semigroup[Int => Int].combine(_ + 1, _ * 10).apply(6))
  //  println(Map("foo" -> Map("bar" -> 5)) ++ Map("foo" -> Map("bar" -> 6), "baz" -> Map()))
  //  println(Map("foo" -> List(1, 2)) ++ Map("foo" -> List(3, 4), "bar" -> List(42)))


  Semigroup[Int].combine(1, 2)
}
