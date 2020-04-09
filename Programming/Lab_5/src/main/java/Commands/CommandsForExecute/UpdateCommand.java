package Commands.CommandsForExecute;

import BasicClasses.HumanBeing;
import BasicClasses.HumanReader;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Класс отвечающий за команду update id
 */

public class UpdateCommand implements CommandIF{
    Hashtable<Integer, HumanBeing> collection;
    Scanner sc;
    public UpdateCommand(Hashtable<Integer, HumanBeing> collection, Scanner sc){
        this.collection=collection;
        this.sc=sc;
    }
    @Override
    public void execute(String[] args) {
        try {
            if(args.length>2) {
                    System.out.println("Веденны неверные аргументы команды");
            }else {
                for (Integer key : collection.keySet()) {
                    if (collection.get(key).getId().equals(Integer.parseInt(args[1]))) {
                        collection.put(key, new HumanReader().humanReader(sc));
                        collection.get(key).setId(Integer.valueOf(args[1]));
                    }
                }
            }
        }catch (NumberFormatException ex){
            System.out.println("Введен некорректный id");
        }catch (NullPointerException ex1){
            System.out.println("Остановка команды");
        }
    }

    /**
     * @return Возращает описание команды
     */
    @Override
    public String infoCommand() {
        return "Команда update id - обновление элемента по id";
    }
}
