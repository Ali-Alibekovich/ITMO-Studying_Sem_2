package Commands.CommandsForExecute;

import BasicClasses.HumanBeing;
import Collection.CollectionManager;
import Commands.CommandExecutor;

import javax.annotation.processing.FilerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.channels.FileLock;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс отвечающий за команду execute_script
 */


public class ExecuteScript implements CommandIF{
    String path;
    Hashtable<Integer, HumanBeing> collection;
    CollectionManager collectionManager;
    Scanner sc;
    static boolean scriptIsRunning=false;
    public static boolean getScriptIsRunning(){
        return scriptIsRunning;
    }
    public ExecuteScript(Hashtable<Integer, HumanBeing> collection, CollectionManager collectionManager){
        this.collection=collection;
        this.collectionManager=collectionManager;
    }

    /**
     *
     * @param args принимает имя файла со скриптом
     */
    @Override
    public void execute(String[] args) {
        try {
            validatePath(args);
            this.sc = new Scanner(new File("resources/"+path));
            CommandsMap commandMap = new CommandsMap(collectionManager,collection,sc,path);
            commandMap.setCommandHashMap();
            CommandExecutor commandExecutor = new CommandExecutor(commandMap.getCommandHashMap());
            while (sc.hasNext()) {
                scriptIsRunning=true;
                commandExecutor.executeCommand(sc.nextLine().toLowerCase().split(" "));
            }
            scriptIsRunning=false;
        }catch (StackOverflowError ex1){
            System.out.println("Обнаружено переполнение стека, вероятнее всего команда execute_script вызывает саму себя");
        }catch (FileNotFoundException ex){
            System.out.println("Файл не найден");
        }catch (NoSuchFieldException ex2){
            System.out.println("У файла нет прав на чтение");
        }
    }


    @Override
    public String infoCommand() {
        return "Команда execute_script - исполняет файл со скриптом";
    }

    /**
     *
     * @param args принимает путь файла и проверяет его на возможность чтения и расширение.
     * @throws FileNotFoundException возращает ошибку если нет прав на чтение
     */
    private void validatePath(String[] args) throws NoSuchFieldException, FileNotFoundException {
        if(!args[1].contains(".txt")){
            args[1]=args[1]+".txt";
        }
        path=args[1];
        File file = new File("resources/"+path);
        if(!file.isFile()){
            throw new FileNotFoundException();
        }
        if(!file.canRead()){
            throw new NoSuchFieldException();
        }
    }
}
