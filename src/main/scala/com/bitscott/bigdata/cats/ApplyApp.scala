package com.bitscott.cats

import cats._, cats.instances._, cats.implicits._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object ApplyApp extends App {

  val addOne: Int => Int = _ + 1
  val addTwo: Int => Int = _ + 2
  println(Apply[List].ap(List(addOne))(List(1, 2, 3)))
  println(Apply[List].ap(List(addOne, addTwo))(List(1, 2, 3)))
  println(Apply[Option].ap(Some(addOne))(Some(4)))
  println((addOne).some ap 5.some)
  println((addOne).some ap None)
  println(List(addOne) ap List(1, 2, 4))
  println()

  val addBoth = (a: Int, b: Int) => a + b
  println((addBoth).some ap2(3.some, 5.some))
  println()

  def ff(a: Future[Int], b: Future[Int]) = (a |@| b).map(_ + _)

  println((5.some, 6.some).mapN(_ + _))

  println(1.show)
}