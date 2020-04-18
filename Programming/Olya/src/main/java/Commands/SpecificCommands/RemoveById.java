package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда remove_by_id.
 */
public class RemoveById extends Command {
    private final Receiver receiver;

    public RemoveById(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m remove_by_id\u001B[0m: удаляется элемент из коллекции по его id.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.remove_by_id(args[1]);
        }
    }
}
