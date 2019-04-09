package com.bitscott.bigdata.cats

import org.scalatest.FlatSpec

import scala.collection.mutable.Stack

class ApplyTest extends FlatSpec {


  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = Stack[Int]()
    stack.push(1)
    stack.push(2)
    assert(stack.pop === 2)
    assert(stack.pop === 1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = Stack[String]()
    assertThrows[NoSuchElementException] {
      emptyStack.pop
    }
  }
}
