package Commands;

import CollectionWorker.CollectionWorker;
import Commands.CommandBank.*;

import java.util.HashMap;
import java.util.Scanner;

public class CommandsCollection {
    public void setCommandHashtable(HashMap<String, Command> commandHashMap, CollectionWorker collectionWorker, Scanner sc, String filename) {
        commandHashMap.put("help",new HelpCommand());
        commandHashMap.put("info",new InfoCommand(collectionWorker));
        commandHashMap.put("insert", new InsertCommand(collectionWorker,sc));
        commandHashMap.put("exit",new ExitCommand());
        commandHashMap.put("history",new HistoryCommand());
        commandHashMap.put("remove_key",new RemoveByKey(collectionWorker));
        commandHashMap.put("execute_script",new Execute_script(collectionWorker,commandHashMap));
        commandHashMap.put("save",new SaveCommand(collectionWorker,filename));
        commandHashMap.put("show",new ShowCommand(collectionWorker));
        commandHashMap.put("load",new LoaderObjects(collectionWorker,filename));
    }
}
