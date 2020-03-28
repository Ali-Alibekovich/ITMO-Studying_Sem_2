package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;
import Commands.CommandsCollection;
import ObjectSpecifications.HumanBeing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

import static ObjectSpecifications.HumanReader.getCatcherError;

public class Execute_script implements Command {
    Hashtable<Integer, HumanBeing> collection;
    HashMap<String,Command> commandHashMap;
    public Execute_script(CollectionWorker collectionWorker, HashMap<String, Command> commandHashMap) {
        this.collection=collectionWorker.getCollection();
        this.commandHashMap=commandHashMap;
    }

    @Override
    public void runCommand(String[] s) {
        String path;
        try {
            if(s[1].contains(".txt")) {
                path = s[1];
            }else {
                path = s[1] + ".txt";
            }
            Scanner sc = new Scanner(new File("resources/"+path));
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
        }catch (ArrayIndexOutOfBoundsException ex1){
            System.out.println("Неверные аргументы команды");
        }
    }

    @Override
    public String toString() {
        return "Команда Execute_script";
    }
}
