import CollectionWorker.CollectionWorker;
import Commands.Command;
import Commands.CommandBank.JsonLoader.ObjectReader;
import Commands.CommandsCollection;
import Commands.CommandBank.CommandsReader;
import ObjectSpecifications.HumanBeing;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String filename;
        if (args.length != 0) {
            filename = "resources/" + args[0];
        } else {
            filename = "resources/Data.json";
        }
        Scanner sc = new Scanner(System.in);//Scanner
        HashMap<String, Command> commandHashMap = new HashMap<>();//Коллекция комманд
        CommandsCollection commandsCollection = new CommandsCollection();//Класс для работы коллекции комманд
        Hashtable<Integer, HumanBeing> humanBeingHashtable = new Hashtable<>();//Коллекция HumanBeings
        CollectionWorker collectionWorker = new CollectionWorker(humanBeingHashtable);//Класс для работы с коллекцией
        commandsCollection.setCommandHashtable(commandHashMap, collectionWorker, sc,filename);//Заполнение коммандами коллекции для комманд
        commandHashMap.get("load").runCommand(null);
        CommandsReader commandsReader = new CommandsReader(commandHashMap, sc);
        commandsReader.runCommand(null);
    }
}

