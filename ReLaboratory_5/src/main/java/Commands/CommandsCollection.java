package Commands;

import CollectionWorker.CollectionWorker;
import Commands.CommandBank.*;

import java.util.HashMap;
import java.util.Scanner;

public class CommandsCollection {
    public void setCommandHashtable(HashMap<String,Command> commandHashMap, CollectionWorker collectionWorker,Scanner sc) {
        commandHashMap.put("help",new HelpCommand());
        commandHashMap.put("info",new InfoCommand(collectionWorker));
        commandHashMap.put("insert null {element}", new InsertCommand(collectionWorker));
        commandHashMap.put("exit",new ExitCommand());
        commandHashMap.put("history",new HistoryCommand());
    }
}
