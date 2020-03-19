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
    public String getAllParam(){
        return "Coordinates{" +"\n"+
                "  \tx=" + x +",\n"+
                "  \ty=" + y +",\n"+
                "}";
    }

    @Override
    public String toString() {
        return "{" +
                "\"x\":" + x +
                ", \"y\":" + y +
                '}';
    }
}
