package Commands.CommandsForExecute;

import BasicClasses.HumanBeing;
import java.util.Hashtable;
import java.util.TreeSet;


/**
 * Класс отвечающий за команду print_ascending
 */

public class PrintAscending implements CommandIF {
    Hashtable<Integer, HumanBeing> collection;

    PrintAscending(Hashtable<Integer, HumanBeing> collection){
        this.collection=collection;
    }
    @Override
    public void execute(String[] args) {
        if (args.length>1){
            System.out.println("Введены неверные агрументы команды. Команда приведена к базовому print_ascending");
        }else {
            TreeSet<Integer> keys = new TreeSet<>(collection.keySet());
            for (Integer key : keys) {
                System.out.println(collection.get(key).getAllParam());
            }
        }
    }

    @Override
    public String infoCommand() {
        return "Команда print_ascending - выводит коллекцию в списке возрастания";
    }
}
