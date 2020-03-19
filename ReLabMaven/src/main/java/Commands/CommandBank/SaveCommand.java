package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;
import ObjectSpecifications.HumanBeing;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

public class SaveCommand implements Command {
    FileWriter fileWriter;
    Hashtable<Integer,HumanBeing> collection;
    String path;
    public SaveCommand(CollectionWorker collectionWorker, String filename) {
        collection=collectionWorker.getCollection();
        this.path=filename;
    }
    @Override
    public void runCommand(String[] s) {
        try {
            File file = new File(path);
            fileWriter=new FileWriter(path);
            if(!file.canWrite()){
                throw new IOException();
            }
            int i=0;
            fileWriter.append("[");
            for (Integer key:collection.keySet()){
                i++;
                if(collection.size()==i){
                    collection.get(key).setKey(key);
                    fileWriter.append(collection.get(key).toString()).append("]");
                }else {
                    collection.get(key).setKey(key);
                    fileWriter.append(collection.get(key).toString()).append(",");
                }
            }
            fileWriter.close();
            System.out.println("Данные сохранены");
        } catch (IOException e) {
            System.out.println("Файл не найден или недостаточно прав");
        }
    }
    @Override
    public String toString() {
        return "Команда Save";
    }
}
