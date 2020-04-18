package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда add_if_min.
 */
public class AddIfMin extends Command {
    private final Receiver receiver;

    public AddIfMin(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m add_if_min\u001B[0m: Добавляется новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.add_if_min();
        }
    }
}
