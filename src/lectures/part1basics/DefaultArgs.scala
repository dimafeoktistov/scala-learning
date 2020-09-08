package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  // Дефолтное значение для параметра
  @tailrec
  def factHelper(x: Int, acc: BigInt = 1): BigInt =
    if (x <= 1) acc
    else factHelper(x - 1, x * acc)

  println(factHelper(10))


  // Можно изменять дефолтные параметры по имени
  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = {}
  savePicture(width = 500)
}
