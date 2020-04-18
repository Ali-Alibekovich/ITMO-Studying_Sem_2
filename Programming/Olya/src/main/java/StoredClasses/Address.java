package StoredClasses;

/**
 * Адрес организации.
 */
public class Address {
    private String street; //Длина строки не должна быть больше 136, Поле может быть null
    private String zipCode; //Длина строки не должна быть больше 26, Поле не может быть null
    private Location town; //Поле не может быть null

    public Address(String street, String zipCode, Location town) {
        this.street = street;
        this.zipCode = zipCode;
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Location getTown() {
        return town;
    }

}