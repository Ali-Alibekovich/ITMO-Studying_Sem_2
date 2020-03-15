package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;
import ObjectSpecifications.HumanBeing;
import ObjectSpecifications.HumanReader;

import java.util.Hashtable;
import java.util.Scanner;

public class InsertCommand implements Command {
    Hashtable<Integer, HumanBeing> collection;
    Scanner sc;
    public InsertCommand(CollectionWorker collectionWorker, Scanner sc) {
        this.collection=collectionWorker.getCollection();
        this.sc=sc;
    }

    @Override
    public void runCommand(String[] s) {
        int key;
        try{
            key=Integer.parseInt(s[1]);
            if(!s[2].toLowerCase().equals("humanbeing")){
                throw new NullPointerException();
            }else {
                collection.put(key,new HumanReader().readHuman(sc));
                System.out.println("Объект создан");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Неправильные аргументы команды");
        }catch (NumberFormatException e){
            System.out.println("Введен неправильный формат ключа");
        }catch (NullPointerException e){
            System.out.println("Такого типа коллекции нет");
        }
    }

    @Override
    public String toString() {
        return "Команда Insert";
    }
}
