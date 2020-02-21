package Commands;

import Commands.Interfaces.Commands;

public class ExitCommand implements Commands {
    @Override
    public String getCommand() {
        return "exitCommand";
    }

    @Override
    public String toString() {
        System.exit(0);
        return getCommand();
    }
}
