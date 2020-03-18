import CollectionWorker.CollectionWorker;
import Commands.Command;
import Commands.CommandsCollection;
import Commands.CommandBank.CommandsReader;
import ObjectSpecifications.HumanBeing;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//Scanner
        HashMap<String, Command> commandHashMap = new HashMap<>();//Коллекция комманд
        CommandsCollection commandsCollection = new CommandsCollection();//Класс для работы коллекции комманд
        Hashtable<Integer, HumanBeing> humanBeingHashtable = new Hashtable<>();//Коллекция HumanBeings
        CollectionWorker collectionWorker = new CollectionWorker(humanBeingHashtable);//Класс для работы с коллекцией
        commandsCollection.setCommandHashtable(commandHashMap, collectionWorker, sc);//Заполнение коммандами коллекции для комманд
        CommandsReader commandsReader = new CommandsReader(commandHashMap, sc);
        commandsReader.runCommand(null);
    }
}

