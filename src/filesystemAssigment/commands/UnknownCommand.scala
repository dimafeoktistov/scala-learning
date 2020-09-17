package filesystemAssigment.commands
import filesystemAssigment.filesystem.State

class UnknownCommand extends Command {
  override def apply(state: State): State =
    state.setMessage("Команда не найдена")
}
