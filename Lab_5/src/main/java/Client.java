import BasicClasses.HumanBeing;
import Collection.CollectionManager;
import Commands.CommandExecutor;
import Commands.CommandsForExecute.CommandsMap;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * @author Чупанов Аликылыч Алибекович, группа P3114
 */


public class Client {
    public static void main(String[] args) {
        String filename;
        if (args.length != 0) {
            filename = "resources/" + args[0];
        } else {
            filename = "resources/Data.json";
        }
        Scanner scanner = new Scanner(System.in);
        Hashtable<Integer, HumanBeing> collection = new Hashtable<>();
        CollectionManager collectionManager= new CollectionManager(collection);
        CommandsMap commandsMap = new CommandsMap(collectionManager, collection, scanner, filename);
        commandsMap.setCommandHashMap();
        commandsMap.getCommandHashMap().get("load").execute("".split(""));
        CommandExecutor commandExecutor = new CommandExecutor(commandsMap.getCommandHashMap());
        while (scanner.hasNextLine()) {
            commandExecutor.executeCommand(scanner.nextLine().toLowerCase().split(" "));
        }
    }
}
