package BasicClasses;
/**
 * Класс Coordinates
 */
public class Coordinates {
    private long x;
    private float y;

    /**
     * Конструктвор для класса Coordinates
     * @param x параметр x принимает значение типа long
     * @param y параметр y принимает значение типа float
     */
    public Coordinates(long x,float y){
        this.x=x;
        this.y=y;
    }

    /**
     *
     * @return возращает параметры класса Coordinates
     */
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

    public long getX() {
        return x;
    }

    public float getY() {
        return y;
    }

}