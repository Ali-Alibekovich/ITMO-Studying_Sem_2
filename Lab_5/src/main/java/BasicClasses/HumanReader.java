package BasicClasses;

import Collection.IDGenerator;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static Commands.CommandsForExecute.ExecuteScript.getScriptIsRunning;

/**
 * Класс считывающий объект HumanBeing
 */

public class HumanReader{
    public static boolean catcherError=true;
    public static boolean getCatcherError(){
        return catcherError;
    }

    /**
     * метод который ловит ошибку во время выполнения скрипта
     * @param catcherError1
     */
    public static void setCatcherError(boolean catcherError1) {
        checker=catcherError1;
        catcherError = catcherError1;
    }
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
    Scanner sc;
    static boolean checker=true;
    /**
     * Конструктор который считывает класс HumanBeing
     * @param sc параметр Scanner
     */
    public HumanBeing humanReader(Scanner sc){
        catcherError=true;
        if(getScriptIsRunning()){
            checker = getCatcherError();
        }else {
            checker =true;
        }
        this.sc=sc;
        this.id= IDGenerator.generateID();
        try {
            this.name = readerName("Введите name", this.sc);
            this.coordinates = readerCoordinates(this.sc);
            this.realHero = readerBoolean("Введите параметр realHero(True/False):", sc);
            this.hasToothpick = readerBoolean("Введите параметр has tooth pick(True/False)", sc);
            this.impactSpeed = readerLong("Введите параметр impactSpeed(> -680):", sc);
            this.minutesOfWaiting = readerFloat("Введите параметр minutes of waiting:", sc);
            this.weaponType = readerWeaponType("Введите параметр weapon type(HAMMER/SHOTGUN/MACHINE_GUN):", sc);
            this.car = readerCar(sc);
            this.mood = readerMood("Введите параметр Mood(GLOOM/RAGE/FRENZY):", sc);
        }catch (NoSuchElementException ex){
            return null;
        }
        if( getScriptIsRunning() && !catcherError){
            return null;
        }
        return new HumanBeing(name, coordinates, realHero, hasToothpick, impactSpeed, minutesOfWaiting, weaponType, mood, car);
    }


    /**
     * @return возращает экземпляр класса car
     */
    private Car readerCar(Scanner sc) {
        String name;
        boolean cool;
        name = readerName("Введите значение name у Car:",sc);
        cool = readerBoolean("Введите значение cool(True/False) у Car:", sc);
        return new Car(name, cool);
    }
    /**
     * @return возращает экземпляр класса coordinates
     */
    private Coordinates readerCoordinates(Scanner sc) {
        long x;
        float y;
        x = readerLong("Введите координату x:", sc);
        y = readerFloat("Введите координату y:", sc);
        return new Coordinates(x, y);
    }
    /**
     * @return возращает переменную типа long
     */
    private long readerLong(String request, Scanner sc) {
        if(!getScriptIsRunning())
        System.out.println(request);
        if(getScriptIsRunning())
        checker = getCatcherError();
        long value = 0;
        while (checker) {
            try {
                String strValue = sc.nextLine();
                value = Long.parseLong(strValue);
                break;
            } catch (NumberFormatException ex) {
                if (!getScriptIsRunning())
                System.out.println("Введите корректное значение");
                if(getScriptIsRunning())
                setCatcherError(false);
            }
        }
        return value;
    }

    /**
     * @return возращает переменную типа Mood
     */
    private Mood readerMood(String request, Scanner sc) {
        if(!getScriptIsRunning())
        System.out.println(request);
        Mood mood = null;
        if(getScriptIsRunning())
        checker = getCatcherError();
        while (checker) {
            try {
                mood = Mood.valueOf(sc.nextLine().toUpperCase().trim());
                break;
            } catch (IllegalArgumentException e) {
                if(!getScriptIsRunning())
                System.out.println("Введите корректное значение");
                if(getScriptIsRunning())
                setCatcherError(false);
            }
        }
        return mood;
    }

    /**
     * @return возращает переменную типа WeaponType
     */
    private WeaponType readerWeaponType(String request, Scanner sc) {
        if(!getScriptIsRunning())
        System.out.println(request);
        WeaponType weaponType = null;
        if(getScriptIsRunning())
        checker = getCatcherError();
        while (checker) {
            try {
                weaponType = WeaponType.valueOf(sc.nextLine().toUpperCase().trim());
                break;
            } catch (IllegalArgumentException e) {
                if(!getScriptIsRunning())
                System.out.println("Введите корректное значение");
                if(getScriptIsRunning())
                setCatcherError(false);
            }
        }
        return weaponType;
    }

    /**
     * @return возращает переменную типа name
     */
    private String readerName(String request,Scanner sc) {
        if(!getScriptIsRunning())
        System.out.println(request);
        String name;
        if(getScriptIsRunning())
        checker = getCatcherError();
        while (checker) {
            try {
                name=sc.nextLine().trim();
                if (!name.isEmpty()) {
                    if(request.contains("Car")) {
                        return name;
                    }else{
                        if (name.matches("[a-zA-Z]+")){
                            return name;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                }else{
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                if(!getScriptIsRunning())
                System.out.println("Введите корректное значение");
                if(getScriptIsRunning())
                setCatcherError(false);
            }
        }
        return null;
    }
    /**
     * @return возращает переменную типа float
     */
    private Float readerFloat(String request, Scanner sc) {
        if(!getScriptIsRunning())
        System.out.println(request);
        if(getScriptIsRunning())
        checker = getCatcherError();
        float value = 0;
        while (checker) {
            try {
                value = Float.parseFloat(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                if(!getScriptIsRunning())
                System.out.println("Введите корректное значение");
                if(getScriptIsRunning())
                setCatcherError(false);
            }
        }
        return value;
    }
    /**
     * @return возращает переменную типа boolean
     */
    private boolean readerBoolean(String request, Scanner sc) {
        if(!getScriptIsRunning())
        System.out.println(request);
        boolean trueOrFalse = false;
        if(getScriptIsRunning())
        checker = getCatcherError();
            while (checker) {
                String[] str = sc.nextLine().toLowerCase().split(" ");
                if (str[0].equals("true")) {
                    trueOrFalse = true;
                    break;
                } else {
                    if (str[0].equals("false")) {
                        trueOrFalse = false;
                        break;
                    } else {
                        if (!getScriptIsRunning())
                            System.out.println("Введите корректное значение");
                        if(getScriptIsRunning())
                        setCatcherError(false);
                    }
                }
            }
        return trueOrFalse;
    }
}
