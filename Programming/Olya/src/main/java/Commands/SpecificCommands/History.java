package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда history.
 */
public class History extends Command {
    private final Receiver receiver;

    public History(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m history\u001B[0m: выводятся 7 последних команд.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.history();
        }
    }
}
