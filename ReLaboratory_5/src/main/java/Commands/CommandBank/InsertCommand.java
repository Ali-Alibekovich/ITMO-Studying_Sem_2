package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;
import ObjectSpecifications.HumanBeing;

import java.util.Hashtable;

public class InsertCommand implements Command {
    Hashtable<Integer, HumanBeing> collection;
    public InsertCommand(CollectionWorker collectionWorker) {
        this.collection=collectionWorker.getCollection();
    }

    @Override
    public void runCommand() {

    }

    @Override
    public String toString() {
        return "Insert";
    }
}
