package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;
import ObjectSpecifications.HumanBeing;

import java.util.*;

/*
    Реализовать команду History.
 */
public class CommandsReader implements Command {
    HashMap<String,Command> commandsCollection;
    HistoryCommand historyCommand = new HistoryCommand();
    Scanner sc;
    public CommandsReader(HashMap<String,Command> commandsCollection, Scanner sc){
        this.commandsCollection=commandsCollection;
        this.sc=sc;
    }


    @Override
    public void runCommand(String[] s) {
        System.out.println("Добро пожаловать в консоль.\n" +
                "Чтобы получить список команд введите help");
        String[] scannedCommand;
        while (true) {
            try {
                scannedCommand = sc.nextLine().toLowerCase().split(" ");
                commandsCollection.get(scannedCommand[0]).runCommand(scannedCommand);
                HistoryCommand.saveCommand(commandsCollection.get(scannedCommand[0]).toString());
            } catch (NoSuchElementException ex) {
                System.out.println("Экстренный выход из коммандной строки");
                break;
            }catch (NullPointerException ex1){
                System.out.println("Такой команды не существует");
            }
        }
    }
}
