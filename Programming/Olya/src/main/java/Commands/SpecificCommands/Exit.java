package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда exit.
 */
public class Exit extends Command {

    private final Receiver receiver;

    public Exit(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m exit\u001B[0m: завершение программы.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.exit();
        }
    }
}