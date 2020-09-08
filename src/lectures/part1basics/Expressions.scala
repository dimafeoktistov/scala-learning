package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // Expression
  var aVariable = 1
  println(x)

  println(2 + 3 * 4)

  // Everything in Scala is an Expression!

  val aWierdValue = aVariable = 3 // Unit === void
  println(aWierdValue)

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  println(aCodeBlock)
}
