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
                int key = jsonArray.getJSONArray(i).getJSONObject(0).getInt("key");
                long id = Long.parseLong(jsonArray.getJSONArray(i).getJSONObject(0).getString("id"));
                String name = jsonArray.getJSONArray(i).getJSONObject(0).getString("name");
                int x = jsonArray.getJSONArray(i).getJSONObject(0).getJSONObject("coordinates").getInt("x");
                double y = jsonArray.getJSONArray(i).getJSONObject(0).getJSONObject("coordinates").getInt("y");
                Coordinates coordinates = new Coordinates(x,y);
                boolean realHero = jsonArray.getJSONArray(i).getJSONObject(0).getBoolean("realHero");
                boolean hasToothpick = jsonArray.getJSONArray(i).getJSONObject(0).getBoolean("hasToothpick");
                double impactSpeed = jsonArray.getJSONArray(i).getJSONObject(0).getDouble("impactSpeed");
                float minutesOfWaiting = jsonArray.getJSONArray(i).getJSONObject(0).getFloat("minutesOfWaiting");
                WeaponType  weaponType = WeaponType.valueOf(jsonArray.getJSONArray(i).getJSONObject(0).getString("weaponType"));
                Mood mood = Mood.valueOf(jsonArray.getJSONArray(i).getJSONObject(0).getString("mood"));
                String nameCar = jsonArray.getJSONArray(i).getJSONObject(0).getJSONObject("car").getString("name");
                boolean cool = jsonArray.getJSONArray(i).getJSONObject(0).getJSONObject("car").getBoolean("cool");
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
        }
    }

    @Override
    public String toString() {
        return null;
    }
}
