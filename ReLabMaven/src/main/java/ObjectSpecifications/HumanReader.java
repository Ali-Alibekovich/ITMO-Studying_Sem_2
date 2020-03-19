package ObjectSpecifications;

import java.util.Scanner;

public class HumanReader {
    private static boolean catcherError;

    public static boolean getCatcherError() {
        return catcherError;
    }

    public static void setCatcherError(boolean catcherError) {
        HumanReader.catcherError = catcherError;
    }

    public HumanBeing readHuman(Scanner sc) {
        catcherError = false;
        String name = readerName("Введите name", sc);
        Coordinates coordinates = readerCoordinates(sc);
        Boolean realHero = readerBoolean("Введите параметр realHero(True/False):", sc);
        Boolean hasToothpick = readerBoolean("Введите параметр has tooth pick(True/False)", sc);
        Double impactSpeed = readerDouble("Введите параметр impactSpeed(> -680):", sc);
        Float minutesOfWaiting = readerFloat("Введите параметр minutes of waiting:", sc);
        WeaponType weaponType = readerWeaponType("Введите параметр weapon type(HAMMER/SHOTGUN/MACHINE_GUN):", sc);
        Car car = readerCar(sc);
        Mood mood = readerMood("Введите параметр Mood(GLOOM/RAGE/FRENZY):", sc);
        return new HumanBeing(name, coordinates, realHero, hasToothpick, impactSpeed, minutesOfWaiting, weaponType, mood, car);
    }

    private Car readerCar(Scanner sc) {
        String name;
        boolean cool;
        name = readerName("Введите значение name у Car:", sc);
        cool = readerBoolean("Введите значение cool(True/False) у Car:", sc);
        return new Car(name, cool);
    }

    private Coordinates readerCoordinates(Scanner sc) {
        int x;
        double y;
        x = readerInteger("Введите координату x:", sc);
        y = readerDouble("Введите координату y:", sc);
        return new Coordinates(x, y);
    }

    private Mood readerMood(String request, Scanner sc) {
        System.out.println(request);
        Mood mood;
        while (true) {
            try {
                mood = Mood.valueOf(sc.nextLine().toUpperCase().trim());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Введите корректное значение");
                setCatcherError(true);
            }
        }
        return mood;
    }


    private WeaponType readerWeaponType(String request, Scanner sc) {
        System.out.println(request);
        WeaponType weaponType;
        while (true) {
            try {
                weaponType = WeaponType.valueOf(sc.nextLine().toUpperCase().trim());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Введите корректное значение");
                setCatcherError(true);
            }
        }
        return weaponType;
    }

    private String readerName(String request, Scanner sc) {
        System.out.println(request);
        String name;
        while (true) {
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
                System.out.println("Введите корректное значение");
                setCatcherError(true);
            }
        }
    }

    private Float readerFloat(String request, Scanner sc) {
        System.out.println(request);
        float minutesOfWaiting;
        while (true) {
            try {
                minutesOfWaiting = Float.parseFloat(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное значение");
                setCatcherError(true);
            }
        }
        return minutesOfWaiting;
    }

    private Double readerDouble(String request, Scanner sc) {
        System.out.println(request);
        double ScannedDouble;
        while (true) {
            try {
                ScannedDouble = Double.parseDouble(sc.nextLine().trim());
                if (request.contains("impactSpeed") && ScannedDouble <= -680) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное значение");
                setCatcherError(true);
            }
        }
        return ScannedDouble;
    }

    private boolean readerBoolean(String request, Scanner sc) {
        System.out.println(request);
        boolean trueOrFalse;
        while (true) {
            String[] str = sc.nextLine().toLowerCase().split(" ");
            if (str[0].equals("true")) {
                trueOrFalse = true;
                break;
            } else {
                if (str[0].equals("false")) {
                    trueOrFalse = false;
                    break;
                } else {
                    System.out.println("Введите корректное значение");
                    setCatcherError(true);
                }
            }
        }
        return trueOrFalse;
    }

    private int readerInteger(String request, Scanner sc) {
        System.out.println(request);
        int Int;
        while (true) {
            try {
                Int = Integer.parseInt(sc.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное значение");
                setCatcherError(true);
            }
        }
        return Int;
    }
}
