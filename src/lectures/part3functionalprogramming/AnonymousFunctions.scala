package lectures.part3functionalprogramming

object AnonymousFunctions extends App {

  // анонимная функция (лямбда)
  val doubler: Int => Int = x => x + 2

  // несколько параметров
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // без параметров
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) // сама функция
  println(justDoSomething()) // вызов

  // вызов в фигурных скобочках
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // Больше синтактического сахара
  val niceIncrementer: Int => Int = _ + 1 // тоже что и x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // тоже что и (a,b) => a + b


}
