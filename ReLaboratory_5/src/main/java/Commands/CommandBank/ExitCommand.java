package Commands.CommandBank;

import Commands.Command;

public class ExitCommand implements Command {

    @Override
    public void runCommand() {
        System.out.println("Работа с консолью завершена");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Команда Exit";
    }
}
