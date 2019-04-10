package com.bitscott.bigdata.cats

import cats._
import cats.implicits._

object MonadApp extends App {
	
	//	Some(1)
	Option(Option(1)).flatten
	//	None
	Option(None).flatten
	//	List(1, 2, 3)
	List(List(1), List(2, 3)).flatten
	
	//	Some(42)
	Monad[Option].pure(42)
	//	List(1, 1, 2, 2, 3, 3)
	Monad[List].flatMap(List(1, 2, 3))(x ⇒ List(x, x))
	//	Some(truthy)
	Monad[Option].ifM(Option(true))(Option("truthy"), Option("falsy"))
	//	List(1, 2, 3, 4, 1, 2)
	Monad[List].ifM(List(true, false, true))(List(1, 2), List(3, 4))
}
