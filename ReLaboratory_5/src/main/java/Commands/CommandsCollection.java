package Commands;

import CollectionWorker.CollectionWorker;

import java.util.HashMap;

public class CommandsCollection {
    public void setCommandHashtable(HashMap<String,Command> commandHashMap, CollectionWorker collectionWorker) {
        commandHashMap.put("help",new HelpCommand());
        commandHashMap.put("info",new InfoCommand(collectionWorker));
    }
}
