package Commands.CommandsForExecute;

import BasicClasses.HumanBeing;
import java.util.Hashtable;

/**
 * Класс отвечающий за команду clear
 */

public class ClearCommand implements CommandIF {
    Hashtable<Integer, HumanBeing> collection;
    public ClearCommand(Hashtable<Integer, HumanBeing> collection) {
        this.collection=collection;
    }

    @Override
    public void execute(String[] s) {
        if(collection.isEmpty()){
            System.out.println("Коллекция пуста");
        }else {
            collection.clear();
            System.out.println("Коллекция очищена");
        }
    }

    @Override
    public String infoCommand() {
        return "Команда clear - очищает коллекцию";
    }

    @Override
    public String toString() {
        return "Команда Clear";
    }
}
