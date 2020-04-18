package StoredClasses;

/**
 * Локауия.
 */
public class Location {
    private float x;
    private float y;
    private String name; //Строка не может быть пустой, Поле не может быть null

    public Location(float x, float y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getName() {
        return name;
    }
}