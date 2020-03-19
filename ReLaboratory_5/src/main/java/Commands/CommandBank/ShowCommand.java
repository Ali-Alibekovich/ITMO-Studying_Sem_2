package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;
import ObjectSpecifications.HumanBeing;

import java.util.Hashtable;

public class ShowCommand implements Command {
    Hashtable <Integer, HumanBeing> collection;
    public ShowCommand(CollectionWorker collectionWorker) {
        collection=collectionWorker.getCollection();
    }

    @Override
    public void runCommand(String[] s) {
        if(collection.keySet().isEmpty()){
            System.out.println("Коллекция пуста");
        }else {
            for (Integer key : collection.keySet()) {
                System.out.println(collection.get(key).getAllParam());
            }
        }
    }
}
