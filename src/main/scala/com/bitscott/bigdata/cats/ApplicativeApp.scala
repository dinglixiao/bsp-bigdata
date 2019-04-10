package com.bitscott.cats

object ApplicativeApp extends App {
	
	
	val f: (Int, Char) => Double = (i, c) => (i + c).toDouble
	
	val int: Option[Int] = Some(5)
	val char: Option[Char] = Some('a')
	
	println(int.map(i => (c: Char) => f(i, c)))
}
