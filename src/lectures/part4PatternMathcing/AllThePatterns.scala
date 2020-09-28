package lectures.part4PatternMathcing

import exercises.{Cons, Empty, MyList}

object AllThePatterns extends App {

  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "String"
    case true => "Boolean"
    case AllThePatterns => "Singleton object"
  }

  // 2 - match anything
  // 2.1 wildcard

  val mathcAnthing = x match {
    case _ => "anything"
  }

  // 2.2 variable
  val matchAVar = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val tuple = (1,2)
  val matchTuple = tuple match {
    case (1,1) =>
    case (something, 2) => something
  }

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) => v
  }
  // PMs can be NESTED!

  // 4 - case classes - constructor patter
  val list: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchList = list match {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) => subtail
  }

  // 5 - list patterns
  val standardList = List(1,2,3)
  val standardListMathcing = standardList match {
    case List(1, _, _) => // extractor - advanced
    case List(1, _*) => // list or arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
  }

  // 6 - type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // 7 - name binding
  val nameBindingMatch = list match {
    case nonEmptyList @ Cons(_, _) => // name binding
    case Cons(1, rest @ Cons(2, _)) => // still works
  }

  // 8 - multi-pattern
  val multipattern = list match {
    case Empty | Cons(0, _) => // compound pattern
  }

  // 9 - if guards
  val secondElementSpecial = list match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
  }
}
