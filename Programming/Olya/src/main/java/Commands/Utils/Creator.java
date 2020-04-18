package Commands.Utils;

import StoredClasses.*;

/**
 * Создатель: создаёт организации.
 */
public class Creator {
    /**
     * Метод - создание организации с помощью консоли.
     *
     * @return созданная организация.
     */
    public static Organization createOrganizationFromConsole() {
        String name = Readers.readName();
        Double cX = Readers.readCoordinatesX();
        double cY = Readers.readCoordinatesY();
        Double annualTurnover = Readers.readAnnualTurnover();
        OrganizationType type = Readers.readType();
        String street = Readers.readStreet();
        String zipCode = Readers.readZipCode();
        float lX = Readers.readLocation("X");
        float lY = Readers.readLocation("Y");
        String locationName = Readers.readTownName();
        return new Organization(name, new Coordinates(cX, cY), annualTurnover, type, new Address(street, zipCode, new Location(lX, lY, locationName)));
    }

    /**
     * Метод - создание организации с помощью скрипта.
     *
     * @param parameters - параметры из скрипта.
     * @return созданная организация.
     */
    public static Organization createOrganizationFromScript(String[] parameters) {
        try {
            if ((!parameters[0].equals("")) && (Double.parseDouble(parameters[1]) <= 643) && (Double.parseDouble(parameters[2]) != 0 || Double.parseDouble(parameters[2]) == 0) &&
                    (Double.parseDouble(parameters[3]) > 0) && (Readers.doesThisOrganizationTypeExist(parameters[4])) &&
                    (parameters[5].length() <= 136) && (!parameters[6].equals("")) && (parameters[6].length() <= 26) && (Float.parseFloat(parameters[7]) != 0 || Float.parseFloat(parameters[7]) == 0) &&
                    (Float.parseFloat(parameters[8]) != 0 || Float.parseFloat(parameters[8]) == 0) && (!parameters[9].equals(""))) {
                return new Organization(parameters[0], new Coordinates(Double.parseDouble(parameters[1]), Double.parseDouble(parameters[2])), Double.parseDouble(parameters[3]),
                        Enum.valueOf(OrganizationType.class, parameters[4]), new Address(parameters[5], parameters[6], new Location(Float.parseFloat(parameters[7]),
                        Float.parseFloat(parameters[8]), parameters[9])));
            } else {
                System.out.println("Что-то не так с параметрами.");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Что-то не так с параметрами.");
            return null;
        }
    }
}