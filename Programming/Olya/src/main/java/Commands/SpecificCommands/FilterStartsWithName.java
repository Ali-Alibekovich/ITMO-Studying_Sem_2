package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда filter_starts_with_name.
 */
public class FilterStartsWithName extends Command {
    private final Receiver receiver;

    public FilterStartsWithName(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m filter_starts_with_name\u001B[0m: выводятся элементы, значение поля name которых начинается с заданной подстроки.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.filter_starts_with_name(args[1]);
        }
    }
}
