package Commands.CommandsForExecute;

import BasicClasses.Car;
import BasicClasses.HumanBeing;
import BasicClasses.HumanReader;
import jdk.nashorn.internal.objects.ArrayBufferView;

import java.lang.reflect.Array;
import java.util.*;

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
            System.out.println("Введены неверные аргументы команды. Команда приведена к базовой print_unique_car");
        }else {
            HashSet<String> cars = new HashSet<>();
            for (Integer key : collection.keySet()) {
                cars.add(collection.get(key).getCar().getAllParam());
            }
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }

    @Override
    public String infoCommand() {
        return "Команда print_unique_car - выводит уникальные поля car";
    }
}
