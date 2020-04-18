package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда update.
 */
public class Update extends Command {
    private final Receiver receiver;

    public Update(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m update_id\u001B[0m: обновляется значение элемента коллекции, id которого равен заданному.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.update(args[1]);
        }
    }
}