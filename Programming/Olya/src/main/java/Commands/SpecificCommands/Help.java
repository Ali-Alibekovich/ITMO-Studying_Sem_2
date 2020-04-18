package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда help.
 */
public class Help extends Command {

    private final Receiver receiver;

    public Help(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m help\u001B[0m: выводится справка по доступным командам.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.help();
        }
    }
}
