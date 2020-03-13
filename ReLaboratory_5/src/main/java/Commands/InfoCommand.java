package Commands;

import CollectionWorker.CollectionWorker;

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
}
