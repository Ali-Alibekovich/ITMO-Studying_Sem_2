package Commands.CommandsForExecute;

import Collection.CollectionManager;

/**
 * Класс отвечающий за команду info
 */

public class InfoCommand implements CommandIF {
    CollectionManager collectionWorker;
    public InfoCommand(CollectionManager collectionWorker){
        this.collectionWorker=collectionWorker;
    }

    @Override
    public void execute(String[] s) {
        System.out.println("Тип коллекции: " + collectionWorker.getCollectionType()+"\n" +
                "Дата инициализации: " + collectionWorker.getDate()+"\n" +
                "Размер коллекции: "+ collectionWorker.getSize());
    }

    @Override
    public String infoCommand() {
        return "Комнада info - показывает информацию о коллекции";
    }

    @Override
    public String toString() {
        return "Команда Info";
    }
}
