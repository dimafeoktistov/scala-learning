package lectures.part2oop

object InheritanceAndTraits extends App {
  sealed class Animal {
    def eat(): Unit = println("nomnomnom")
  }

  class Cat extends Animal {
    def crunch(): Unit = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  final class Dog extends Animal {
    final override def eat(): Unit = println("woof, woof")
  }

  val dog = new Dog
  dog.eat

  // type substitution (полиморфизм)
  val unknownAnimal: Animal = new Dog()
  unknownAnimal.eat

  // Защита от перезаписывания
  // final на поле или классе
  // sealed - на классе
}
