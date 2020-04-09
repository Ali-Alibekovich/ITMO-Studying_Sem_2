package Commands.CommandsForExecute;

import BasicClasses.HumanBeing;

import java.util.Hashtable;

/**
 * Класс отвечающий за команду show
 */
public class ShowCommand implements CommandIF {
    Hashtable <Integer, HumanBeing> collection;
    public ShowCommand(Hashtable<Integer,HumanBeing> collection) {
        this.collection=collection;
    }


    @Override
    public void execute(String[] s) {
        showingCollection();
    }

    @Override
    public String infoCommand() {
        return "Команда Show - выводит все элементы коллекции";
    }


    public void showingCollection(){
        if(collection.keySet().isEmpty()){
            System.out.println("Коллекция пуста");
        }else {
            for (Integer key : collection.keySet()) {
                System.out.println(collection.get(key).getAllParam());
            }
        }
    }

}
