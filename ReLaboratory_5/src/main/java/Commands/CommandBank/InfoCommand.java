package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;

public class InfoCommand implements Command {
    CollectionWorker collectionWorker;
    public InfoCommand(CollectionWorker collectionWorker){
        this.collectionWorker=collectionWorker;
    }
    @Override
    public void runCommand() {
        System.out.println("Тип коллекции: " + collectionWorker.getCollectionType()+"\n" +
                "Дата инициализации: " + collectionWorker.getCreationDate()+"\n" +
                "Размер коллекции: "+ collectionWorker.getSize());
    }

    @Override
    public String toString() {
        return "InfoCommand";
    }
}
