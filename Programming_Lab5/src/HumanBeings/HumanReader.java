package HumanBeings;

import Collection.MyCollection;

import java.time.ZonedDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public  class HumanReader {
    public static boolean catchedError=false;
    public static HumanBeing readHuman(Scanner sc, MyCollection collection){
        String name = readerName("Введите имя", sc);
        Coordinates coordinates=readerCoordinates("Введите координаты(x,y):",sc);
        Boolean realHero = readerBoolean("Введите параметр realHero(True/False):",sc);
        Boolean hasToothpick = readerBoolean("Введите параметр has tooth pick(True/False)",sc);
        Double impactSpeed=readerDouble("Введите параметр impactSpeed(>-680):",sc);
        Float minutesOfWaiting = readerFloat("Введите параметр minutes of waiting:",sc);
        return HumanBeing(name,coordinates,realHero,hasToothpick,impactSpeed,);
    }

    private static Float readerFloat(String request, Scanner sc) throws InputMismatchException{
        while(true) {
            try {

            } catch (InputMismatchException e) {
                System.out.println("Введите корректное значение");
            }
        }
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
        String o="";
        o=sc.nextLine().trim();
        return o;
    }

}
