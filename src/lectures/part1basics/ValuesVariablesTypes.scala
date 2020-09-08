package lectures.part1basics


object ValuesVariablesTypes extends App {
  val x = 42
  println(x)

  val aString: String = "Hello"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 500
  val aLong: Long = 900000000000L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  aVariable = 5 // side effects
}
