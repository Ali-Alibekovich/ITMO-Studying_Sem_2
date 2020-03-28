package Commands.CommandsForExecute;

import BasicClasses.HumanBeing;
import BasicClasses.HumanReader;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Класс отвечающий за команду remove_lower
 */

public class RemoveLower implements CommandIF {
    Hashtable<Integer, HumanBeing> collection;
    Scanner sc;
    public RemoveLower(Hashtable<Integer, HumanBeing> collection, Scanner sc){
        this.collection=collection;
        this.sc=sc;
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
                System.out.println("Введны неправильные аргументы команды. Команда приведена к базовой команде remove_lower");
        } else {
            HumanBeing humanBeing = new HumanReader().humanReader(sc);
            TreeSet<Integer> keys = new TreeSet<>(collection.keySet());
            for (Integer key : keys) {
                if (humanBeing.compareTo(collection.get(key)) > 0) {
                    collection.remove(key);
                }
            }
        }
    }

    @Override
    public String infoCommand() {
        return "Команда remove_lower {element} - удаляет элементы приывашющие заданный";
    }
}
