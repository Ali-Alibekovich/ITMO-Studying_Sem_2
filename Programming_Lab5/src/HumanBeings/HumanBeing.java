package HumanBeings;
import java.time.ZonedDateTime;
import java.util.UUID;

public class HumanBeing implements Comparable<HumanBeing> {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private Boolean hasToothpick; //Поле не может быть null
    private Double impactSpeed; //Значение поля должно быть больше -680, Поле может быть null
    private Float minutesOfWaiting; //Поле может быть null
    private WeaponType weaponType; //Поле не может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле не может быть null

    public HumanBeing(String name, Coordinates coordinates, Boolean realHero, Boolean hasToothpick, Double impactSpeed, Float minutesOfWaiting, WeaponType weaponType, Mood mood, Car car){
        java.time.ZonedDateTime creationDate = ZonedDateTime.now();
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
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

    private Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
    public Boolean getRealHero() {
        return realHero;
    }
    public Boolean getHasToothpick() {
        return hasToothpick;
    }
    public Double getImpactSpeed() {
        return impactSpeed;
    }
    public Float getMinutesOfWaiting() {
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

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean setMood(Mood mood) {
        if(mood==null){
            return false;
        }
        this.mood = mood;
        return true;
    }

    public boolean setWeaponType(WeaponType weaponType) {
        if(weaponType==null){
            return false;
        }
        this.weaponType = weaponType;
        return true;
    }

    public boolean setMinutesOfWaiting(Float minutesOfWaiting) {
        if(minutesOfWaiting==null){
            return false;
        }
        this.minutesOfWaiting = minutesOfWaiting;
        return true;
    }


    public boolean setImpactSpeed(Double impactSpeed) {
        if(impactSpeed<-680||impactSpeed==null){
            return false;
        }
        this.impactSpeed = impactSpeed;
        return true;
    }

    public boolean setHasToothpick(Boolean hasToothpick) {
        if (hasToothpick==null){
            return false;
        }
        this.hasToothpick = hasToothpick;
        return true;
    }

    public boolean setName(String name) {
        if(name.equals("")||name==null){
            return false;
        }
        this.name = name;
        return true;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean setRealHero(Boolean realHero) {
        if(realHero==null){
            return false;
        }
        this.realHero = realHero;
        return true;
    }
    @Override
    public int compareTo(HumanBeing o) {
        /*
        Sorting by key
         */
        return (int) (this.getId()-o.getId());
    }

    @Override
    public String toString() {
        return "HumanBeing{" +"\n"+
                "\tid=" + id +",\n"+
                "\tname='" + name + '\'' +",\n"+
                "\tcoordinates=" + coordinates +",\n"+
                "\tcreationDate=" + creationDate +",\n"+
                "\trealHero=" + realHero +",\n"+
                "\thasToothpick=" + hasToothpick +",\n"+
                "\timpactSpeed=" + impactSpeed +",\n"+
                "\tminutesOfWaiting=" + minutesOfWaiting +",\n"+
                "\tweaponType=" + weaponType +",\n"+
                "\tmood=" + mood +",\n"+
                "\tcar=" + car +"\n"+
                '}';
    }
}

