package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else {
      println("Computing factorial of " + n)
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      println(result)

      result
    }
  }

  @tailrec
  def factHelper(x: Int, acc: BigInt): BigInt =
    if (x <= 1) acc
    else factHelper(x - 1, x * acc)

  // println(factHelper(5000, 1))

  @tailrec
  def repStr(s: String, n: Int, acc: String): String =
    if (n == 0) acc
    else repStr(s, n - 1, acc + s + " ")


  def fib(n: Int): BigInt = {
    @tailrec
    def tailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else tailRec(i + 1, last + nextToLast, last)
    }
    if (n <= 2) 1
    else tailRec(2,  1, 1)
  }

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailRec(n / 2, true)
  }

  // println(repStr("Hello", 10000, ""))
  // factorial(5000)
}
