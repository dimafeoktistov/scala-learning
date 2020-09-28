package lectures.part3functionalprogramming

import scala.util.Random

object Sequences extends App {

  // Sequences
  val sequence = Seq(3, 2, 1, 4)
  println(sequence)
  println(sequence.reverse)
  println(sequence(2))
  println(sequence ++ Seq(7,5,6))
  println(sequence.sorted)

  // Ranges
  val range = 1 to 10
  range.foreach(println)

  // Lists
  val list = List(1,2,3)
  val prepended = 42 :: list
  println(prepended)
  val appending = 42 +: list :+ 89
  println(appending)

  val apple5 = List.fill(5)("apple")
  println(apple5)
  println(list.mkString("-|-"))

  // Arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0 // синтактический сахар для numbers.update(2, 0)
  println(numbers.mkString(" "))

  // arrays and seq
  val numberSeq: Seq[Int] = numbers // неявная конверсия
  println(numberSeq)

  // Vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vectors vs lists

  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // Сохраняет связь с хвостом
  // Обновление элемента по средине долго
  println(getWriteTime(numbersList))
  // глубина дерева маленькая
  // нужно заменить всю ветку
  println(getWriteTime(numbersVector))
}
