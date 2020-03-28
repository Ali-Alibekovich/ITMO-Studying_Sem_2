package Commands.CommandsForExecute;

import BasicClasses.HumanBeing;
import java.util.Hashtable;

/**
 * Класс отвечающий за команду print_unique_car
 */


public class PrintUniqueCar implements CommandIF {
    Hashtable<Integer, HumanBeing> collection;
    public PrintUniqueCar(Hashtable<Integer, HumanBeing> collection){
        this.collection=collection;
    }
    @Override
    public void execute(String[] args) {
        if(args.length>1){
            System.out.println("Ведены неверные аргументы команды. Команда приведена к базовой print_unique_car");
        }else {
            for (Integer key : collection.keySet()) {
                    System.out.println("HumanBeing with key - " + collection.get(key).getKey() + "\n" + collection.get(key).getCar().getAllParam());
            }
        }
    }

    @Override
    public String infoCommand() {
        return "Команда print_unique_car - выводит уникальные поля car";
    }
}
