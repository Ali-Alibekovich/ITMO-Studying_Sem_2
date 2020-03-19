package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;
import ObjectSpecifications.HumanBeing;

import java.util.HashMap;
import java.util.Hashtable;

public class Execute_script implements Command {
    Hashtable<Integer, HumanBeing> collection;
    HashMap<String,Command> commandHashMap;
    public Execute_script(CollectionWorker collectionWorker, HashMap<String, Command> commandHashMap) {
        this.collection=collectionWorker.getCollection();
        this.commandHashMap=commandHashMap;
    }

    @Override
    public void runCommand(String[] s) {
        String path;
        if(s[1].contains(".txt")) {
            path = s[1];
        }else{
            path = s[1]+".txt";
        }
        System.out.println(path);
//        while(!getCatcherError()) {
//
//        }
    }

    @Override
    public String toString() {
        return "Команда Execute_script";
    }
}
