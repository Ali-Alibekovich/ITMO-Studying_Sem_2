package BasicClasses;

import Collection.IDGenerator;
import java.util.Date;

/**
 * Основной класс HumanBeing
 */

public class HumanBeing implements Comparable<HumanBeing> {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private Boolean hasToothpick; //Поле не может быть null
    private Long impactSpeed; //Значение поля должно быть больше -680, Поле может быть null
    private float minutesOfWaiting;
    private WeaponType weaponType; //Поле не может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле не может быть null
    private int key;
    /**
     * Конструктор для класса HumanBeing
     */
    public HumanBeing(String name, Coordinates coordinates, Boolean realHero,  Boolean hasToothpick, Long impactSpeed, float minutesOfWaiting, WeaponType weaponType, Mood mood, Car car){
        this.id = IDGenerator.generateID();
        this.creationDate = new Date();
        this.name=name;
        this.coordinates=coordinates;
        this.realHero=realHero;
        this.hasToothpick=hasToothpick;
        this.impactSpeed=impactSpeed;
        this.minutesOfWaiting=minutesOfWaiting;
        this.weaponType=weaponType;
        this.mood=mood;
        this.car=car;
    }

    /**
     * Конструктор для класса HumanBeing с полем id
     */
    public HumanBeing(Integer id,int key,String name, Coordinates coordinates, Boolean realHero, Boolean hasToothpick, Long impactSpeed, Float minutesOfWaiting, WeaponType weaponType, Mood mood, Car car){
        this.creationDate = new Date();
        this.key=key;
        this.id = id;
        this.name=name;
        this.coordinates=coordinates;
        this.realHero=realHero;
        this.hasToothpick=hasToothpick;
        this.impactSpeed=impactSpeed;
        this.minutesOfWaiting=minutesOfWaiting;
        this.weaponType=weaponType;
        this.mood=mood;
        this.car=car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Boolean getRealHero() {
        return realHero;
    }

    public Boolean getHasToothpick() {
        return hasToothpick;
    }

    public Long getImpactSpeed() {
        return impactSpeed;
    }

    public float getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public Mood getMood() {
        return mood;
    }

    public Car getCar() {
        return car;
    }

    /**
     *
     * @return Вощрашает все параметры класса HumanBeing
     */
    public String getAllParam(){
        return "HumanBeing{" +"\n"+
                "  id=" + id +",\n"+
                "  key="+key+",\n"+
                "  name='" + name + '\'' +",\n"+
                coordinates.getAllParam() +",\n"+
                "  realHero=" + realHero +",\n"+
                "  hasToothpick=" + hasToothpick +",\n"+
                "  impactSpeed=" + impactSpeed +",\n"+
                "  minutesOfWaiting=" + minutesOfWaiting +",\n"+
                "  weaponType=" + weaponType +",\n"+
                "  mood=" + mood +",\n"+
                car.getAllParam() +",\n"+
                '}';
    }
    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" +"\""+ id +"\"" +
                ", \"key\":" + key +
                ", \"name\":"+"\"" + name +"\"" +
                ", \"coordinates\":" + coordinates +
                ", \"realHero\":" + realHero +
                ", \"hasToothpick\":" + hasToothpick +
                ", \"impactSpeed\":" + impactSpeed +
                ", \"minutesOfWaiting\":" + minutesOfWaiting +
                ", \"weaponType\":"+"\"" + weaponType +"\""+
                ", \"mood\":" +"\""+ mood +"\""+
                ", \"car\":" + car +
                "}";
    }

    @Override
    public int compareTo(HumanBeing humanBeing) {
        return (int) (this.impactSpeed - humanBeing.impactSpeed);
    }
}

