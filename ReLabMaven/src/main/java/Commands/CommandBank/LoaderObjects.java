package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;
import ObjectSpecifications.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;

public class LoaderObjects implements Command {
    Hashtable <Integer, HumanBeing> collection;
    String path;
    public LoaderObjects(CollectionWorker collectionWorker, String filename) {
        collection=collectionWorker.getCollection();
        this.path=filename;
    }
    //Just ReworkThisShit
    @Override
    public void runCommand(String[] s) {
        try {
            boolean first=true;
            Scanner reader = new Scanner(new InputStreamReader(new FileInputStream(path)));
            File file = new File(path);
            if(!file.canRead()){
                throw new NullPointerException();
            }
            JSONArray jsonArray = new JSONArray(reader.nextLine());
            for (int i=0; i<jsonArray.length(); i++) {
                int key = jsonArray.getJSONObject(i).getInt("key");
                long id = Long.parseLong(jsonArray.getJSONObject(i).getString("id"));
                String name = jsonArray.getJSONObject(i).getString("name");
                int x = jsonArray.getJSONObject(i).getJSONObject("coordinates").getInt("x");
                double y = jsonArray.getJSONObject(i).getJSONObject("coordinates").getInt("y");
                Coordinates coordinates = new Coordinates(x,y);
                boolean realHero = jsonArray.getJSONObject(i).getBoolean("realHero");
                boolean hasToothpick = jsonArray.getJSONObject(i).getBoolean("hasToothpick");
                double impactSpeed = jsonArray.getJSONObject(i).getDouble("impactSpeed");
                float minutesOfWaiting = jsonArray.getJSONObject(i).getFloat("minutesOfWaiting");
                WeaponType  weaponType = WeaponType.valueOf(jsonArray.getJSONObject(i).getString("weaponType"));
                Mood mood = Mood.valueOf(jsonArray.getJSONObject(i).getString("mood"));
                String nameCar = jsonArray.getJSONObject(i).getJSONObject("car").getString("name");
                boolean cool = jsonArray.getJSONObject(i).getJSONObject("car").getBoolean("cool");
                Car car = new Car(nameCar,cool);
                collection.put(key,new HumanBeing(id,name,coordinates,realHero,hasToothpick,impactSpeed,minutesOfWaiting,weaponType,mood,car));
            }
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
    public String toString() {
        return null;
    }
}
