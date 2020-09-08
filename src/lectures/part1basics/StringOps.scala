package lectures.part1basics

object StringOps extends App {
  val s: String = "SOme string"

  println(s.charAt(2))
  println(s.substring(0, 2))
  println(s.split(" ").toList)
  println(s.startsWith("SOme"))
  println(s.replace(" ", "-"))
  println(s.length())

  val numStr = "45"
  val num = numStr.toInt
  println('a' +: numStr :+ 'z')
  println(s.reverse)
  println(s.take(2))

  // Интерполяторы строки

  // S- интерполяторы
  val name = "Dima"
  val age = 29
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I am ${age + 1} years old"
  println(anotherGreeting)

  // F- интерполяторы
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw- интерполятор
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
