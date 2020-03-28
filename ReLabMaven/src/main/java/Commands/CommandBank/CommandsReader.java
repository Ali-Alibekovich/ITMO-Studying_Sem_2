package Commands.CommandBank;
import Commands.Command;
import java.util.*;
import static ObjectSpecifications.HumanReader.setCatcherError;


public class CommandsReader implements Command {
    HashMap<String,Command> commandsCollection;
    Scanner sc;
    public CommandsReader(HashMap<String,Command> commandsCollection, Scanner sc){
        this.commandsCollection=commandsCollection;
        this.sc=sc;
    }


    @Override
    public void runCommand(String[] s) {
        System.out.println("Добро пожаловать в консоль.\n" +
                "Чтобы получить список команд введите help");
        while (true) {
            try {
                runner();
            } catch (NoSuchElementException ex) {
                System.out.println("Экстренный выход из коммандной строки");
                System.exit(0);
                break;
            }catch (NullPointerException ex1){
                System.out.println("Такой команды не существует");
                setCatcherError(true);
            }
        }
    }

    public void runner()throws NoSuchElementException,NullPointerException {
        String[] scannedCommand = sc.nextLine().toLowerCase().split(" ");
        commandsCollection.get(scannedCommand[0]).runCommand(scannedCommand);
        HistoryCommand.saveCommand(commandsCollection.get(scannedCommand[0]).toString());
    }
}
