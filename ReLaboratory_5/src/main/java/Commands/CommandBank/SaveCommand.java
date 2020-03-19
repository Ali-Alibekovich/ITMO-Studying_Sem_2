package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;
import ObjectSpecifications.HumanBeing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

public class SaveCommand implements Command {
    FileWriter fileWriter;
    Hashtable<Integer,HumanBeing> collection;
    public SaveCommand(CollectionWorker collectionWorker) {
        collection=collectionWorker.getCollection();
    }

    @Override
    public void runCommand(String[] s) {
        try {
            File file = new File("src\\main\\java\\Data\\Collection.txt");
            fileWriter=new FileWriter("src\\main\\java\\Data\\Collection.txt");
            if(!file.canWrite()){
                throw new IOException();
            }
            for (Integer key:collection.keySet()){
                fileWriter.append(collection.get(key).toString());
            }
            System.out.println("Файл успешно сохранен");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Файл не найден или недостаточно прав");
        }
    }
}
