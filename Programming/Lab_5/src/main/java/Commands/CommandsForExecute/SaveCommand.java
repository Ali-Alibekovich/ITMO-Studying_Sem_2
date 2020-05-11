package Commands.CommandsForExecute;

import BasicClasses.HumanBeing;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import static Commands.CommandsForExecute.ExecuteScript.getScriptIsRunning;

/**
 * Класс отвечающий за команду save
 */


public class SaveCommand implements CommandIF {
    FileWriter fileWriter;
    Hashtable<Integer,HumanBeing> collection;
    String path;

    @Override
    public void execute(String[] s) {
        try {
            validateReadable(path);
            savingCollection(path);
            if(!getScriptIsRunning())
            System.out.println("Данные сохранены");
        } catch (IOException e) {
            System.out.println("недостаточно прав");
        }
    }

    @Override
    public String  infoCommand() {
        return "Команда save - сохранение коллекции в файл";
    }


    public void savingCollection(String path) throws IOException {
        fileWriter=new FileWriter(path);
        int i=0;
        fileWriter.append("[");
        for (Integer key:collection.keySet()){
            i++;
            if(collection.size()==i){
                collection.get(key).setKey(key);
                fileWriter.append(collection.get(key).toString()).append("]");
            }
            else{
                collection.get(key).setKey(key);
                fileWriter.append(collection.get(key).toString()).append(",");
            }
        }
        fileWriter.close();
    }


    public void validateReadable(String path) throws IOException {
        File file = new File(path);
        if(!file.canWrite()){
            throw new IOException();
        }
    }




    public SaveCommand(Hashtable<Integer, HumanBeing> collection, String filename) {
        this.collection=collection;
        this.path=filename;
    }



    @Override
    public String toString() {
        return "Команда Save";
    }
}
