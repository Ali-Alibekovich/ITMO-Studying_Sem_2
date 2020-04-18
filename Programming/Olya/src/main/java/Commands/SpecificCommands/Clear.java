package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда clear.
 */

public class Clear extends Command {

    private final Receiver receiver;

    public Clear(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m clear\u001B[0m: очистка коллекции.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.clear();
        }
    }
}