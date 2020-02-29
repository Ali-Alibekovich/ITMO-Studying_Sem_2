package HumanBeings;
import java.util.Scanner;
public abstract   class HumanReader {
    public static boolean catchedError;
    public static boolean errorForCycle;
    public static HumanBeing readHuman(Scanner sc){
        catchedError = false;
        errorForCycle=false;
        String name = readerName("Введите имя", sc);
        Coordinates coordinates=readerCoordinates("Введите координаты(x,y):",sc);
        Boolean realHero = readerBoolean("Введите параметр realHero(True/False):",sc);
        Boolean hasToothpick = readerBoolean("Введите параметр has tooth pick(True/False)",sc);
        Double impactSpeed=readerDouble("Введите параметр impactSpeed(>-680):",sc);
        Float minutesOfWaiting = readerFloat("Введите параметр minutes of waiting:",sc);
        WeaponType weaponType= readerWeaponType("Введите параметр weapon type(HAMMER/SHOTGUN/MACHINE_GUN):",sc);
        Car car = readerCar("Введите параметры name и cool(True/False) у Car:",sc);
        Mood mood = readerMood("Введите параметр Mood(GLOOM/RAGE/FRENZY):",sc);
        if(errorForCycle){
            return new HumanBeing(name, coordinates, realHero, hasToothpick, impactSpeed, minutesOfWaiting, weaponType, mood, car);
        }else{
            return null;
        }
    }
    private static Mood readerMood(String request, Scanner sc){
        System.out.println(request);
        errorForCycle=false;
        Mood mood;
        while(true){
            try {
                mood=Mood.valueOf(sc.nextLine().trim());
                errorForCycle=true;
                break;
            }catch (Exception e){
                System.out.println("Введите корректное значение ");
                catchedError=true;
            }
        }
        return mood;
    }

    private static Car readerCar(String request, Scanner sc){
        System.out.println(request);
        errorForCycle=false;
        String name;
        boolean cool;
        while (true) {
            String[] str = sc.nextLine().split(" ");
            name=str[0];
            if(str.length<2){
                System.out.println("Введите корректное значение");
                catchedError=true;
            }else {
                if (str[1].equals("True") || str[1].equals("true")) {
                    cool = true;
                    errorForCycle=true;
                    break;
                } else {
                    if (str[1].equals("False") || str[1].equals("false")) {
                        cool = false;
                        errorForCycle=true;
                        break;
                    } else {
                        System.out.println("Введите корректное значение");
                        catchedError=true;
                    }
                }
            }
        }
        return new Car(name,cool);
    }

    private static WeaponType readerWeaponType(String request, Scanner sc){
        System.out.println(request);
        errorForCycle=false;
        WeaponType weaponType;
        while (true){
            try {
                weaponType=WeaponType.valueOf(sc.nextLine().trim());
                errorForCycle=true;
                break;
            }catch (Exception e){
                System.out.println("Введите корректное значение");
                catchedError=true;
            }
        }
        return weaponType;
    }


    private static Float readerFloat(String request, Scanner sc){
        System.out.println(request);
        errorForCycle=false;
        float minutesOfWaiting;
        while(true) {
            try {
                minutesOfWaiting= Float.parseFloat(sc.nextLine());
                errorForCycle=true;
                break;
            }catch (Exception e){
                System.out.println("Введите корректное значение ");
                catchedError=true;
            }
        }
        return minutesOfWaiting;
    }

    private static Double readerDouble(String request,Scanner sc){
        System.out.println(request);
        errorForCycle=false;
        double impactSpeed;
        while(true) {
            try {
                impactSpeed= Double.parseDouble(sc.nextLine());
                if(impactSpeed<-680){
                    throw new Exception();
                }
                errorForCycle=true;
                break;
            }catch (Exception e){
                System.out.println("Введите корректное значение ");
                catchedError=true;
            }
        }
        return impactSpeed;
    }

    private static boolean readerBoolean(String request,Scanner sc){
        System.out.println(request);
        errorForCycle=false;
        boolean trueOrFalse;
        while (true) {
            String[] str = sc.nextLine().split(" ");
            if(str[0].equals("True")||str[0].equals("true")){
                trueOrFalse=true;
                errorForCycle=true;
                break;
            }else{
                if (str[0].equals("False")||str[0].equals("false")){
                    trueOrFalse=false;
                    errorForCycle=true;
                    break;
                }else{
                    System.out.println("Введите корректное значение");
                    catchedError=true;
                }
            }
        }
        return trueOrFalse;
    }

    private static Coordinates readerCoordinates(String request, Scanner sc){
        System.out.println(request);
        errorForCycle=false;
        int x;
        double y;
        while(true) {
            String[] line=sc.nextLine().split(" ");
            if(line.length<2){
                System.out.println("Введите корректное значение");
                catchedError=true;
                continue;
            }
            try {
                x = Integer.parseInt(line[0]);
                y = Double.parseDouble(line[1]);
                errorForCycle=true;
                break;
            }catch (Exception e){
                System.out.println("Введите корректное значение");
                catchedError=true;
            }
        }
        return new Coordinates(x,y);
    }

    public static String readerName(String request, Scanner sc){
        System.out.println(request);
        errorForCycle=false;
        String name=sc.nextLine().trim();
        while(name.equals("")){
            System.out.println("Поле имя не может быть пустым.");
            name=sc.nextLine().trim();
            errorForCycle=true;
            catchedError=true;
        }
        return name;
    }

}
