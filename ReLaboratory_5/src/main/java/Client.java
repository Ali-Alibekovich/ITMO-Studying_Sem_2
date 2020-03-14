import CollectionWorker.CollectionWorker;
import Commands.Command;
import Commands.CommandsCollection;
import ObjectSpecifications.HumanBeing;
import ObjectSpecifications.HumanReader;
import ObjectSpecifications.WeaponType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//Scanner
        HashMap<String,Command> commandHashMap = new HashMap<>();//Коллекция комманд
        CommandsCollection commandsCollection = new CommandsCollection();//Класс для работы коллекции комманд
        Hashtable<Integer, HumanBeing> humanBeingHashtable = new Hashtable<>();//Коллекция HumanBeings
        CollectionWorker collectionWorker = new CollectionWorker(humanBeingHashtable);//Класс для работы с коллекцией
        commandsCollection.setCommandHashtable(commandHashMap,collectionWorker);//Заполнение коммандами коллекции для комманд


        //тесты
        humanBeingHashtable.put(1,new HumanReader().readHuman(sc));
        humanBeingHashtable.put(2,new HumanReader().readHuman(sc));
        humanBeingHashtable.put(3,new HumanReader().readHuman(sc));
        System.out.println(humanBeingHashtable);
        commandHashMap.get("info").runCommand();
    }
}
