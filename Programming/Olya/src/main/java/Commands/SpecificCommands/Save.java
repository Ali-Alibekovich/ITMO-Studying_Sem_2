package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда save.
 */
public class Save extends Command {
    private final Receiver receiver;

    public Save(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m save\u001B[0m: коллекция сохраняется в файл.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.save();
        }
    }
}
