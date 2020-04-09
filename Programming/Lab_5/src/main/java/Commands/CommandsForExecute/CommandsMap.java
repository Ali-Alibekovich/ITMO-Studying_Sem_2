package Commands.CommandsForExecute;

import BasicClasses.HumanBeing;
import Collection.CollectionManager;
import Commands.CommandsForExecute.JsonLoader.LoaderObjects;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
/**
 * Класс который регистрирует все команды
 */

public class CommandsMap {
    HashMap<String, CommandIF> commandHashMap=new HashMap<>();
    CollectionManager collectionManager;
    Hashtable<Integer,HumanBeing> collection;
    Scanner sc;
    String filepath;

    public CommandsMap(CollectionManager collectionManager, Hashtable<Integer, HumanBeing> collection, Scanner sc, String filepath){
        this.collection=collection;
        this.collectionManager=collectionManager;
        this.sc=sc;
        this.filepath=filepath;
    }

    public void setCommandHashMap() {
        commandHashMap.put("help",new HelpCommand());
        commandHashMap.put("exit",new ExitCommand());
        commandHashMap.put("insert",new InsertCommand(collection,sc));
        commandHashMap.put("execute_script",new ExecuteScript(collection,collectionManager));
        commandHashMap.put("show",new ShowCommand(collection));
        commandHashMap.put("remove_key",new RemoveByKey(collection));
        commandHashMap.put("save",new SaveCommand(collection,filepath));
        commandHashMap.put("load",new LoaderObjects(collection,filepath));
        commandHashMap.put("history",new HistoryCommand());
        commandHashMap.put("info", new InfoCommand(collectionManager));
        commandHashMap.put("clear",new ClearCommand(collection));
        commandHashMap.put("update",new UpdateCommand(collection,sc));
        commandHashMap.put("filter_by_weapon_type",new FilterByWeaponType(collection));
        commandHashMap.put("print_unique_car", new PrintUniqueCar(collection));
        commandHashMap.put("print_ascending", new PrintAscending(collection));
        commandHashMap.put("remove_lower",new RemoveLower(collection,sc));
        commandHashMap.put("remove_greater",new RemoveGreater(collection,sc));
    }

    public HashMap<String, CommandIF> getCommandHashMap() {
        return commandHashMap;
    }
}
