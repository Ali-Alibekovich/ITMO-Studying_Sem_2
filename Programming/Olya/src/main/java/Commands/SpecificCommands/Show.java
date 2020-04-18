package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда show.
 */
public class Show extends Command {
    private final Receiver receiver;

    public Show(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m show\u001B[0m: выводятся все элементы коллекции в строковом представлении.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.show();
        }
    }
}
