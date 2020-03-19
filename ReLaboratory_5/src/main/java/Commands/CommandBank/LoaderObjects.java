package Commands.CommandBank;

import CollectionWorker.CollectionWorker;
import Commands.Command;
import ObjectSpecifications.*;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Scanner;

public class LoaderObjects implements Command {
    InputStreamReader fileReader;
    Hashtable <Integer, HumanBeing> collection;
    public LoaderObjects(CollectionWorker collectionWorker) {
        collection=collectionWorker.getCollection();
    }

    @Override
    public void runCommand(String[] s) {
        try {
            Scanner reader = new Scanner(new InputStreamReader(new FileInputStream("src\\main\\java\\Data\\Collection.txt")));
            while (reader.hasNext()) {
                String obj = reader.nextLine();
                JSONObject userJson = new JSONObject(obj);
                int key = userJson.getJSONObject("HumanBeing").getInt("key");
                long id = Long.parseLong(userJson.getJSONObject("HumanBeing").getString("id"));
                String name = userJson.getJSONObject("HumanBeing").getString("name");
                int x = userJson.getJSONObject("HumanBeing").getJSONObject("coordinates").getInt("x");
                double y = userJson.getJSONObject("HumanBeing").getJSONObject("coordinates").getInt("y");
                Coordinates coordinates = new Coordinates(x,y);
                boolean realHero = userJson.getJSONObject("HumanBeing").getBoolean("realHero");
                boolean hasToothpick = userJson.getJSONObject("HumanBeing").getBoolean("hasToothpick");
                double impactSpeed = userJson.getJSONObject("HumanBeing").getDouble("impactSpeed");
                float minutesOfWaiting = userJson.getJSONObject("HumanBeing").getFloat("minutesOfWaiting");
                WeaponType  weaponType = WeaponType.valueOf(userJson.getJSONObject("HumanBeing").getString("weaponType"));
                Mood mood = Mood.valueOf(userJson.getJSONObject("HumanBeing").getString("mood"));
                String nameCar = userJson.getJSONObject("HumanBeing").getJSONObject("car").getString("name");
                boolean cool = userJson.getJSONObject("HumanBeing").getJSONObject("car").getBoolean("cool");
                Car car = new Car(nameCar,cool);
                collection.put(key,new HumanBeing(id,name,coordinates,realHero,hasToothpick,impactSpeed,minutesOfWaiting,weaponType,mood,car));
            }
        }catch (FileNotFoundException ex1) {
            System.out.println("Не удалось найти файл подгрузки данных");
        }
    }
}
