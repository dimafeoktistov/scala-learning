package lectures.part3functionalprogramming

object TuplesAndMaps extends App {

  // tuples - конечные направленные Lists
  val aTuple = Tuple2(2, "Hello, Scala")
  val aTuple2 = (2, "Hello, Scala")

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, Scala", 2)

  // Maps - keys -> values
  val map: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), "Daniel" -> 789, "JIM" -> 777).withDefaultValue(-1) // Если нет значения
  // a -> b сахар для (a,b)

  // map операции
  println(phoneBook.contains("Jim")) // true
  println(phoneBook("Jim")) // 555
  println(phoneBook("Mary")) // Ошибка, если нет дефолтного значения

  // добавить запись
  val newEntry = "Mary" -> 678
  val newPhonebook = phoneBook + newEntry

  // методы map
  // map, flatMap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filter
  println(phoneBook.filter(pair => pair._1.equals("Jim")))
  // mapValues
  println(phoneBook.view.mapValues(number => number * 10).toMap)

  // конвертация
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String) = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unFriend(network: Map[String, Set[String]], a: String, b: String) = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unFriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unFriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))
}
