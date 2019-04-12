package com.bitscott.cats

import com.bitscott.entity.Car
import cats._
import cats.implicits._

object Test extends App {
	
	//	println(123.asRight[String])
	//  println("mom".reverse == "mom")
	//  println("mom".reverse.eq("mom"))
	
	val list1 = new java.util.ArrayList[Int];
	{
		//    println("Created list1")
	}
	val list2 = new java.util.ArrayList[Int] {
		//    println("Created list2")
	}
	//  println(list1.getClass)
	//  println(list2.getClass)
	
	val c1 = new Car(1)
	val c2 = new Car(2)
	//  println(c1)
	//  println(c2.position)
	
	val array = Array(1, 2, 3, 4, 5, 6)
	//  println((0 /: array) { (sum, ele) => ele + sum })
	//  println((3 /: array) (_ + _))
	//  println((Integer.MIN_VALUE /: array) (Integer.max))
	
	val result = for (i <- 1 to 10) yield i * 2
	
	//  println(result)
	
	case class User(name: String)
	
	case class Users(ppl: List[User])
	
	val testUsers = List(User("test1"), User("test2")).asRight[List[User]]
	
}
