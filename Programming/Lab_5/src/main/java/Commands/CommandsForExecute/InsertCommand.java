package Commands.CommandsForExecute;

import BasicClasses.HumanBeing;
import BasicClasses.HumanReader;
import java.util.Hashtable;
import java.util.Scanner;
import static Commands.CommandsForExecute.ExecuteScript.getScriptIsRunning;

/**
 * Класс отвечающий за команду insert key
 */

public class InsertCommand implements CommandIF {
    Hashtable<Integer, HumanBeing> collection;
    Scanner sc;
    public InsertCommand(Hashtable<Integer, HumanBeing> collection, Scanner sc) {
        this.collection=collection;
        this.sc=sc;
    }

    @Override
    public void execute(String[] args) {
        try {
            if(args.length<2){
                if(!getScriptIsRunning())
                System.out.println("Неверно введены аргументы команды");
            }else {
                collection.put(Integer.valueOf(args[1]), new HumanReader().humanReader(sc));
                collection.get(Integer.parseInt(args[1])).setKey(Integer.parseInt(args[1]));
            }
        }catch (NumberFormatException ex){
            if(!getScriptIsRunning())
            System.out.println("Неверный формат ключв");
        }catch (NullPointerException ex1){
            System.out.println("Найдена ошибка в данных при считывании HumanBeing.Объект не создан");
        }
    }

    @Override
    public String infoCommand() {
        return "Команда insert key {element} - создание нового объекта по ключу";
    }
}
