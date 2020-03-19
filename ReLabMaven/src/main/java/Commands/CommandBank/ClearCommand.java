package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;
import ObjectSpecifications.HumanBeing;

import java.util.Hashtable;

public class ClearCommand implements Command {
    Hashtable<Integer, HumanBeing> collection;
    public ClearCommand(CollectionWorker collectionWorker) {
        collection=collectionWorker.getCollection();
    }

    @Override
    public void runCommand(String[] s) {
        if(collection.isEmpty()){
            System.out.println("Коллекция пуста");
        }else {
            collection.clear();
            System.out.println("Коллекция очищена");
        }
    }

    @Override
    public String toString() {
        return "Команда Clear";
    }
}
