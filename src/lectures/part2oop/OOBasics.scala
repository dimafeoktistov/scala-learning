package lectures.part2oop

object OOBasics extends App {

  val p = new Person("John", 26)
  println(p.age)
  println(p.x)
  println(p.greet("Dima"))
  println(p.greet)

  val count = new Counter(1)
  println(count.increment().increment().currentValue())
}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2 // field

  println(4)

  // method
  def greet(name: String): Unit = println(s"Hi $name! from ${this.name}")

  // overloading
  def greet(): Unit = println(s"Hi I am $name!")

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

class Writer(firstName: String, surname: String, val birthYear: Int) {
  def fullName(): String = s"$firstName $surname"
}

class Novel(name: String, releaseYear: Int, var author: Writer) {
  def authorAge(): Int = releaseYear - author.birthYear

  def isWrittenBy(author: Writer): Boolean = this.author == author

  def copy(releaseYear: Int): Novel = new Novel(this.name, releaseYear, this.author)
}

class Counter(initial: Int) {
  def currentValue(): Int = this.initial

  def increment(): Counter = new Counter(this.initial + 1)
  def decrement(): Counter = new Counter(this.initial - 1)

  def increment(value: Int): Counter = new Counter(this.initial + value)
  def decrement(value: Int): Counter = new Counter(this.initial - value)
}
