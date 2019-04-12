package com.bitscott.bigdata.cats

import cats.data.NonEmptyList

object NonEmptyListApp extends App {
	
	//	List(a,b,c) ⇒ List(List(a), List(a,b), List(a,b,c))
	val allPaths = NonEmptyList.of(1, 2, 3).reverse.coflatMap(_.toList.reverse).reverse
	
	
}
