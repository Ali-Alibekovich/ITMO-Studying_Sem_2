package Commands.CommandsForExecute.JsonLoader;

import BasicClasses.HumanBeing;
import Commands.CommandsForExecute.CommandIF;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс отвечающий за команду подгрузки файла json
 */

public class LoaderObjects implements CommandIF {
    Hashtable <Integer, HumanBeing> collection;
    String path;
    public LoaderObjects(Hashtable<Integer,HumanBeing> collection, String filename) {
        this.collection=collection;
        this.path=filename;
    }


    @Override
    public void execute(String[] s) {
        try {
            File file = new File(path);
            if(!file.isFile()){
                throw new FileNotFoundException();
            }
            if(!file.canRead()){
                throw new NullPointerException();
            }
            Scanner reader = new Scanner(new InputStreamReader(new FileInputStream(path)));
            JSONArray jsonArray = new JSONArray(reader.nextLine());
            ObjectReader objectReader=new ObjectReader(jsonArray,collection);
            objectReader.getObjects();
            System.out.println("Коллекция из файла загружена");
        }catch (FileNotFoundException ex1) {
            System.out.println("Не удалось найти файл подгрузки данных");
        }catch (NullPointerException ex2){
            System.out.println("у Файла нет прав на чтение");
        }catch (NoSuchElementException ex3){
            System.out.println("Файл пуст");
        }catch (JSONException ex4){
            System.out.println("Файл пуст или ошибка в данных");
        }
    }

    @Override
    public String infoCommand() {
        return "Подгрузка данных из файла";
    }

    @Override
    public String toString() {
        return null;
    }
}
