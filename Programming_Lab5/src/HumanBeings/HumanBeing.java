package HumanBeings;

import java.util.Objects;
import java.util.UUID;

public class HumanBeing {
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

    HumanBeing(String name, Coordinates coordinates, Boolean realHero, Boolean hasToothpick, Double impactSpeed, Float minutesOfWaiting, WeaponType weaponType, Mood mood, Car car) throws IllegalArgumentException, NullPointerException{
        java.time.ZonedDateTime creationDate = java.time.ZonedDateTime.now();
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException("invalid name");
        }
        if(impactSpeed==null || impactSpeed<=-680 ) {
            throw new IllegalArgumentException("invalid Speed");
        }
        this.creationDate=creationDate;
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.name=name;
        this.impactSpeed=impactSpeed;
        this.coordinates= Objects.requireNonNull(coordinates,"invalid coordinates");
        this.realHero=Objects.requireNonNull(realHero,"invalid realHero");
        this.hasToothpick=Objects.requireNonNull(hasToothpick,"invalid hasToothpick");
        this.minutesOfWaiting=Objects.requireNonNull(minutesOfWaiting,"invalid minutesOfWaiting");
        this.weaponType=Objects.requireNonNull(weaponType,"invalid weaponType");
        this.mood=Objects.requireNonNull(mood,"invalid mood");
        this.car=Objects.requireNonNull(car,"invalid car");
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

    public Long getId() {
        return id;
    }

}

