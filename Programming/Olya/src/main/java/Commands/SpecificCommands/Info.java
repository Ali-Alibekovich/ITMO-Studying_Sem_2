package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда info.
 */
public class Info extends Command {

    private final Receiver receiver;

    public Info(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m info\u001B[0m: выводится информация о коллекции.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.info();
        }
    }
}

