package Commands;

import java.util.HashMap;

public class CommandsBank{
    HashMap<String,InterfaceCommand> commandHashMap = new HashMap<>();

    public void setCommandHashMap(HashMap<String, InterfaceCommand> commandHashMap) {
        commandHashMap.put("help",new helpCommand());
    }
}
