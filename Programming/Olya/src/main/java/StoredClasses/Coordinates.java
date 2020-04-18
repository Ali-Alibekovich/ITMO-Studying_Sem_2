package StoredClasses;

/**
 * Координаты.
 */
public class Coordinates {
    private Double x; //Максимальное значение поля: 643, Поле не может быть null
    private double y;

    public Coordinates(Double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}