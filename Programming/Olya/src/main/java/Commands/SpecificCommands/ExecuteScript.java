package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда execute_script.
 */
public class ExecuteScript extends Command {
    private final Receiver receiver;
    private static String path;

    public ExecuteScript(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m execute_script\u001B[0m: считывается и исполняется скрипт из указанного файла.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            path = args[1];
            receiver.execute_script(args[1]);
        }
    }

    public static String getPath() {
        return path;
    }
}

