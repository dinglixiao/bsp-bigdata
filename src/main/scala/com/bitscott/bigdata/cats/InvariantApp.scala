package com.bitscott.cats

import cats.implicits._
import cats.{Invariant, Semigroup}

import scala.concurrent.duration._

object InvariantApp extends App {

  val durSemigroup: Semigroup[FiniteDuration] = Invariant[Semigroup].imap(Semigroup[Long])(Duration.fromNanos)(_.toNanos)
  println(durSemigroup.combine(2.seconds, 3.seconds))
}
