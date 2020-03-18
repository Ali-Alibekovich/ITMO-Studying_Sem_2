package ObjectSpecifications;

public class Coordinates {
    private int x;
    private double y;

    public double getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    public Coordinates(int x, double y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "{" +
                "\"x\":" + x +
                ", \"y\":" + y +
                '}';
    }
}
