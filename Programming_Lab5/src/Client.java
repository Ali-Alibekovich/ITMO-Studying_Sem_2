import Commands.CommandsBank;
import Commands.InterfaceCommand;
import HumanBeings.HumanBeing;
import HumanBeings.HumanReader;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashtable<Integer, HumanBeing> collection = new Hashtable<>();
        HashMap <String, InterfaceCommand> comHash = new HashMap<>();
        CommandsBank commandsBank = new CommandsBank();
        commandsBank.setCommandHashMap(comHash);
        comHash.get("help").runCommand();
        collection.put(1, new HumanReader().readHuman(sc));
    }
}