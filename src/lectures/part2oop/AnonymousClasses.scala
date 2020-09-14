package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahhaa")
  }
  /*
    equivalent with
      class AnonymousClasses$$anon$1 extends Animal {
        override def eat: Unit = println("ahahhaa")
      }
      val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"hi $name")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, I am jim")
  }
}
