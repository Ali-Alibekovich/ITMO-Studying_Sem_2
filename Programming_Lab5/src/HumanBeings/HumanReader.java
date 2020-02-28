package HumanBeings;
import Collection.MyCollection;
import java.util.InputMismatchException;
import java.util.Scanner;
public  class HumanReader {
    public static boolean catchedError=false;
    public static HumanBeing readHuman(Scanner sc){
        String name = readerName("Введите имя", sc);
        Coordinates coordinates=readerCoordinates("Введите координаты(x,y):",sc);
        Boolean realHero = readerBoolean("Введите параметр realHero(True/False):",sc);
        Boolean hasToothpick = readerBoolean("Введите параметр has tooth pick(True/False)",sc);
        Double impactSpeed=readerDouble("Введите параметр impactSpeed(>-680):",sc);
        Float minutesOfWaiting = readerFloat("Введите параметр minutes of waiting:",sc);
        WeaponType weaponType= readerWeaponType("Введите параметр weapon type(HAMMER/SHOTGUN/MACHINE_GUN):",sc);
        Car car = readerCar("Введите параметры Car(name и cool(True/False)):",sc);
        Mood mood = readerMood("Введите параметр Mood(GLOOM/RAGE/FRENZY):",sc);
        return new HumanBeing(name,coordinates,realHero,hasToothpick,impactSpeed,minutesOfWaiting, weaponType, mood,car);
    }

    private static Mood readerMood(String request, Scanner sc) throws IllegalArgumentException{
        System.out.println(request);
        Mood mood;
        while(true){
            try {
                mood=Mood.valueOf(sc.nextLine().trim());
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Введите корректное значение");
                catchedError=true;
            }
        }
        return mood;
    }

    private static Car readerCar(String request, Scanner sc) throws InputMismatchException{
        String name;
        boolean cool;
        while(true){
            try {
                name=sc.nextLine().trim();
                cool=sc.nextBoolean();
                break;
            }catch (InputMismatchException e){
                System.out.println("Введите корректное значение");
                catchedError=true;
            }
        }
        return new Car(name,cool);
    }

    private static WeaponType readerWeaponType(String request, Scanner sc) throws IllegalArgumentException{
        System.out.println(request);
        WeaponType weaponType;
        while (true){
            try {
                weaponType=WeaponType.valueOf(sc.nextLine().trim());
                break;
            }catch (IllegalArgumentException e){
                System.out.println("Введите корректное значение");
                catchedError=true;
            }
        }
        return weaponType;
    }


    private static Float readerFloat(String request, Scanner sc) throws InputMismatchException{
        System.out.println(request);
        float minutesOfWaiting;
        while(true) {
            try {
                minutesOfWaiting=sc.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введите корректное значение");
                catchedError=true;
            }
        }
        return minutesOfWaiting;
    }

    private static Double readerDouble(String request,Scanner sc) throws InputMismatchException {
        System.out.println(request);
        double impactSpeed;
        while(true) {
            try {
                impactSpeed=sc.nextDouble();
                if(impactSpeed<-680){
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введите корректное значение");
                catchedError = true;
            }
        }
        return impactSpeed;
    }

    private static boolean readerBoolean(String request,Scanner sc) throws InputMismatchException {
        System.out.println(request);
        boolean trueOrFalse;
        while (true) {
            try {
                trueOrFalse = sc.nextBoolean();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введите корректное значение");
                catchedError=true;
            }
        }
        return trueOrFalse;
    }

    private static Coordinates readerCoordinates(String request, Scanner sc) throws InputMismatchException {
        System.out.println(request);
        int x;
        double y;
        while(true) {
            try {
                x = sc.nextInt();
                y = sc.nextDouble();
                break;
            }catch (InputMismatchException e){
                System.out.println("Введите корректное значение координат");
                catchedError=true;
            }
        }
        return new Coordinates(x,y);
    }

    public static String readerName(String request, Scanner sc){
        System.out.println(request);
        String o=sc.nextLine().trim();
        while(o.equals("")){
            System.out.println("Поле имя не может быть пустым.");
            o=sc.nextLine().trim();
            catchedError=true;
        }
        return o;
    }

}
