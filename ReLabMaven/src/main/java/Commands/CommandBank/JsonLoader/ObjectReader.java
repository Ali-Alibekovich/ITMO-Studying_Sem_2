package Commands.CommandBank.JsonLoader;

import ObjectSpecifications.*;
import org.json.JSONArray;
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
            collection.put(getInt("key"),new HumanBeing( getLong("id"), getInt("key"),
                           getString("name"), coordinates(), getBoolean("realHero"), getBoolean("hasToothpick"),
                           getDouble("impactSpeed"), getFloat("minutesOfWaiting"),
                           WeaponType.valueOf(getString("weaponType")), Mood.valueOf(getString("mood")), car())
            );
        }
    }

    public Car car(){
        String name=jsonArray.getJSONObject(i).getJSONObject("car").getString("name");
        boolean cool=jsonArray.getJSONObject(i).getJSONObject("car").getBoolean("cool");
        return new Car(name,cool);
    }


    public Coordinates coordinates (){
        int x = jsonArray.getJSONObject(i).getJSONObject("coordinates").getInt("x");
        double y = jsonArray.getJSONObject(i).getJSONObject("coordinates").getDouble("x");
        return new Coordinates(x,y);
    }

    @Override
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
