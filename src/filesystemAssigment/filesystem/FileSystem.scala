package filesystemAssigment.filesystem

import java.util.Scanner

import filesystemAssigment.commands.Command
import filesystemAssigment.files.Directory

object FileSystem extends App {

  val root = Directory.ROOT
  var state = State(root, root)
  val scanner = new Scanner(System.in)

  while (true) {
    state.show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
  }
}
