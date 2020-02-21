package Commands;
import Commands.Interfaces.Commands;
import java.util.HashMap;
import java.util.Scanner;

public class CommandProcessing {
    public CommandProcessing(){
        setCommands();
    }
    HashMap<String, Commands> commands = new HashMap<>();
    public void setCommands(){
        commands.put("help", new HelpCommand());
        commands.put("exit",new ExitCommand());
    }
    public void readCommands(Scanner command) {
        while (true) {
            String strCommand = command.nextLine();
            if (commands.get(strCommand) == null) {
                System.out.println("Такой команды нет.\nБолее подробная информация по команде help");
            } else {
                System.out.println(commands.get(strCommand));
            }
        }
    }
}
