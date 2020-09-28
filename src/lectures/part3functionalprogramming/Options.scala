package lectures.part3functionalprogramming

import java.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // Работа с unsafe APIs
  def unsafeMethod(): String = null

  // val result = Some(unsafeMethod()) // Неправильно - внутри всегда должно быть значение
  val correctResult = Option(unsafeMethod()) // Some или None
  println(correctResult)

  // chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // Создание unsafe API
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterRes = betterUnsafeMethod() orElse betterBackupMethod()

  // методы
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // Небезопасно

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions

  val config: Map[String, String] = Map(
    "host" -> "192.168.0.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }
  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection())
      else None
  }

  val host = config.get("host")
  val port = config.get("port")
  /*
    if (h != null)
      if (p != null)
        return Connection.apply(h, p)
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))
  /*
    if (connection != null)
       return c.connect
    return null
   */
  val connectionStatus = connection.map(c => c.connect)
  println(connectionStatus)
  connectionStatus.foreach(println)

  // chained calls
  config.get("host")
    .flatMap(h => config.get("port")
      .flatMap(p => Connection(h, p))
      .map(c => c.connect))
    .foreach(println)

  // for loop
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  forConnectionStatus.foreach(println)
}
