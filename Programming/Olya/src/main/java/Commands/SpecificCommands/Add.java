package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда add.
 */
public class Add extends Command {
    private final Receiver receiver;

    public Add(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m add\u001B[0m: в коллекцию добавляется новый элемент.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.add();
        }
    }
}
