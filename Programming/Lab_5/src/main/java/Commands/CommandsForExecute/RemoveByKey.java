package Commands.CommandsForExecute;

import BasicClasses.HumanBeing;
import java.util.Hashtable;

/**
 * Класс отвечающий за команду remove_key
 */

public class RemoveByKey implements CommandIF {
    Hashtable<Integer, HumanBeing> collection;
    public RemoveByKey(Hashtable<Integer, HumanBeing> collection) {
        this.collection=collection;
    }

    @Override
    public void execute(String[] s) {
        try {
            int key = Integer.parseInt(s[1]);
            removeByKey(key);
        }catch (NumberFormatException e){
            System.out.println("Неверно введен ключ");;
        }
    }

    @Override
    public String  infoCommand() {
        return "Команда remove_by key - удаление объекта по ключу";
    }

    /**
     *
     * @param key ключ введенный пользователем
     */
    public void removeByKey(int key){
        if(collection.containsKey(key)){
            collection.remove(key);
            System.out.println("Объект был удален");
        }else {
            System.out.println("Объект не найден");
        }
    }
}
