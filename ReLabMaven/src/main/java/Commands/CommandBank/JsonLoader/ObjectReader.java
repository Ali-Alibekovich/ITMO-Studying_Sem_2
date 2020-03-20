package Commands.CommandBank.JsonLoader;

import CollectionWorker.Collection;
import ObjectSpecifications.*;
import org.json.JSONArray;

import java.time.ZonedDateTime;
import java.util.Hashtable;

public class ObjectReader implements Fields {
    JSONArray jsonArray;
    Hashtable <Integer,HumanBeing> collection;
    int i;
    public ObjectReader(JSONArray jsonArray,Hashtable<Integer,HumanBeing> collection){
        this.jsonArray=jsonArray;
        this.collection=collection;
        i=jsonArray.length();
    }
    public void getObjects(){
        for (this.i=0; i<jsonArray.length(); i++) {
            int key = getInt("key");
            long id = getLong("id");
            String name=getString("name");
            Coordinates coordinates = Coordinates();
            boolean realHero = getBoolean("realHero");
            boolean hasToothpick = getBoolean("hasToothpick");
            double impactSpeed = getDouble("impactSpeed");
            float minutesOfWaiting = getFloat("minutesOfWaiting");
            WeaponType weaponType = WeaponType.valueOf(getString("weaponType"));
            Mood mood = Mood.valueOf(getString("mood"));
            Car car = car();
            collection.put(key,new HumanBeing(id,name,coordinates,realHero,hasToothpick,impactSpeed,minutesOfWaiting,weaponType,mood,car));
        }
    }

    public Car car(){
        String name=jsonArray.getJSONObject(i).getJSONObject("car").getString("name");
        boolean cool=jsonArray.getJSONObject(i).getJSONObject("car").getBoolean("cool");
        return new Car(name,cool);
    }
    public Coordinates Coordinates (){
        int x = jsonArray.getJSONObject(i).getJSONObject("coordinates").getInt("x");
        double y = jsonArray.getJSONObject(i).getJSONObject("coordinates").getDouble("x");
        return new Coordinates(x,y);
    }
    public long getLong(String s){
        return jsonArray.getJSONObject(i).getLong(s);
    }
    @Override
    public int getInt(String s) {
        return jsonArray.getJSONObject(i).getInt(s);
    }

    @Override
    public boolean getBoolean(String s) {
        return jsonArray.getJSONObject(i).getBoolean(s);
    }

    @Override
    public float getFloat(String s) {
        return jsonArray.getJSONObject(i).getFloat(s);
    }

    @Override
    public String getString(String s) {
        return jsonArray.getJSONObject(i).getString(s);
    }

    @Override
    public double getDouble(String s) {
        return jsonArray.getJSONObject(i).getDouble(s);
    }
}
