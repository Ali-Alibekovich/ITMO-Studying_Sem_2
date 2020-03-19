package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;
import ObjectSpecifications.HumanBeing;
import ObjectSpecifications.HumanReader;

import java.util.Hashtable;
import java.util.Scanner;

import static ObjectSpecifications.HumanReader.setCatcherError;

public class InsertCommand implements Command {
    Hashtable<Integer, HumanBeing> collection;
    Scanner sc;
    public InsertCommand(CollectionWorker collectionWorker, Scanner sc) {
        this.collection=collectionWorker.getCollection();
        this.sc=sc;
    }

    @Override
    public void runCommand(String[] s){
        int key;
        try{
            key=Integer.parseInt(s[1]);
            if(!s[2].toLowerCase().equals("humanbeing")){
                throw new NullPointerException();
            }else {
                collection.put(key,new HumanReader().readHuman(sc));
                collection.get(key).setKey(key);
                System.out.println("Объект создан");
            }

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Неправильные аргументы команды");
            setCatcherError(true);
        }catch (NumberFormatException e){
            System.out.println("Введен неправильный формат ключа");
            setCatcherError(true);
        }catch (NullPointerException e){
            System.out.println("Такого типа коллекции нет");
            setCatcherError(true);
        }
    }

    @Override
    public String toString() {
        return "Команда Insert";
    }
}
