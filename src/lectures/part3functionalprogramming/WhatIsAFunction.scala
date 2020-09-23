package lectures.part3functionalprogramming

object WhatIsAFunction extends App {

  // function first class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function1[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // Все скала функции это объекты

  val concatenate: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println("Hello ", "Scala")

  // Function1[Int, Function1[Int, Int]]
  val superAdder: Int => Int => Int = x => y => x + y

  val adder3 = superAdder(3)
  println(superAdder(3)(2)) // каррирование
  println(adder3(2))
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
