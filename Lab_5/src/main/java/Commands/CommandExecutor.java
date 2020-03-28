package Commands;

import Commands.CommandsForExecute.CommandIF;
import java.util.HashMap;
import static Commands.CommandsForExecute.ExecuteScript.getScriptIsRunning;
import static Commands.CommandsForExecute.HistoryCommand.saveCommand;

/**
 * Класс отвечающий за выполнение команд.
 */
public class CommandExecutor {
    HashMap<String, CommandIF> commandMap;

    public CommandExecutor(HashMap<String,CommandIF> commandMap){
        this.commandMap=commandMap;
    }
    public void executeCommand(String[] commandName){
        try {
            if (commandName.length > 0) {
                CommandIF command = commandMap.get(commandName[0]);
                command.execute(commandName);
                saveCommand(commandMap.get(commandName[0]).infoCommand());
            } else {
                if(!getScriptIsRunning())
                System.out.println("Вы не ввели команду.");
            }
        } catch (IllegalStateException | NullPointerException ex) {
            if(!getScriptIsRunning())
            System.out.println("Не существует команды " + commandName[0] + ". Для справки используйте – help");
        }
    }
}
