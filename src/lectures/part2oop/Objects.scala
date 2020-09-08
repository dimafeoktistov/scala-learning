package lectures.part2oop

object Objects {

  def main(args: Array[String]): Unit = {
    // В Scala нет концепции "static"
    object Person { // тип + только один инстанс
      // static функциональность
      val N_EYES = 2
      def canFly: Boolean = false

      // factory method
      def apply(mother: Person, father: Person): Person = new Person("Bobbie")
    }
    class Person(val name: String) {
      // функциональность инстанса
    }

    // COMPANIONS

    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = инстанс синглетона
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val bobbie = Person(mary, john)

    // Scala Applications = Scala объект с методом def main(args: Array[String]): Unit
  }
}
