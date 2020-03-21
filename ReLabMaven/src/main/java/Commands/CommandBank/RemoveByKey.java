package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;
import ObjectSpecifications.HumanBeing;
import java.util.Hashtable;
import static ObjectSpecifications.HumanReader.setCatcherError;

public class RemoveByKey implements Command {
    Hashtable<Integer, HumanBeing> collection;
    public RemoveByKey(CollectionWorker collectionWorker) {
        collection=collectionWorker.getCollection();
    }

    @Override
    public void runCommand(String[] s) {
        try {
            int key = Integer.parseInt(s[1]);
            removeByKey(key);
        }catch (NumberFormatException e){
            System.out.println("Неверно введен ключ");
            setCatcherError(true);
        }
    }



    public void removeByKey(int key){
        if(collection.containsKey(key)){
            collection.remove(key);
            System.out.println("Объект был удален");
        }else {
            System.out.println("Объект не найден");
        }
    }
}
