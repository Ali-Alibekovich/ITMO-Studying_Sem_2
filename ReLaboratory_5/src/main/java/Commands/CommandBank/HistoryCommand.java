package Commands.CommandBank;

import CollectionWorker.Collection;
import Commands.Command;

public class HistoryCommand implements Command {
    @Override
    public void runCommand() {
        for (String s : CommandsReader.commandHistory){
            System.out.println(s);
        }
    }

    @Override
    public String toString() {
        return "history";
    }
}
