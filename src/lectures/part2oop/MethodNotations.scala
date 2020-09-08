package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} with ${person.name}"
    def +(nickName: String): Person = new Person(s"$name ($nickName)", favoriteMovie, age)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def unary_! : String = s"$name, what the heck!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(num: Int): String = s"$name, watched $favoriteMovie $num times"
    def learns(language: String): String = s"$name learns $language"
    def learnsScala : String = this.learns("Scala")
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  // infix notation = operator notation (синтаксический сахар)
  println(mary likes "Inception") // equivalent

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // Все операторы методы

  // prefix notation
  val x = -1 // тоже что и 1.unary_-
  val y = 1.unary_-

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // тоже самое

  println((+mary).age)
  println(mary learnsScala)

  println(mary.apply(2))
  println(mary(2))
}
