package filesystemAssigment.commands
import filesystemAssigment.files.{DirEntry, Directory}
import filesystemAssigment.filesystem.State

class MkDir(name: String) extends Command {
  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(name)) {
      state.setMessage(s"Папка $name уже существует!")
    } else if (name.contains(Directory.SEPARATOR)) {
      // mkdir something/somethingelse
      state.setMessage(s"$name не должно содержать сепараторов")
    } else if (checkName(name)) {
      state.setMessage(s"$name содержит запрещённые символы")
    } else {
      doMkDir(name, state)
    }
  }

  def checkName(name: String): Boolean = {
    name.contains(".")
  }

  def doMkDir(name: String, state: State): State = {
    def updateStructure(currDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = {
      /*
         /a/b
            (contents)
            (new entry) /e

         updateStructure(root, ["a", "b"])
          => path.isEmpty?
          => oldEntry = /a
          root.replaceEntry("a", updateStructure(/a, ["b"], /e)
            => path.isEmpty?
            => oldEntry = /b
            /a.replaceEntry("b", updateStructure(/b, [], /e)
              => path.isEmpty? => /b.add(/e)
       */
      if (path.isEmpty) currDirectory.addEntry(newEntry).asDirectory
      else {
        val oldEntry = currDirectory.findEntry(path.head).asDirectory
        currDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, path.tail, newEntry))
      }
    }

    val wd = state.wd

    // 1. получить все директории в полном пути
    val allDirInPath = wd.getAllFoldersInPath

    // 2. создать новую директорию
    val newDir = Directory.empty(wd.path, name)

    // 3. обновить всю структуру
    val newRoot = updateStructure(state.root, allDirInPath, newDir)

    // 4. найти новую рабочую директорию
    val newWd = newRoot.findDescendent(allDirInPath)

    State(newRoot, newWd)
  }
}
