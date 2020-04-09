package BasicClasses;
/**
 * Класс Car
 */
public class Car {
    private String name; //Поле не может быть null
    private Boolean cool; //Поле не может быть null

    /**
     * @param name параметр name машины
     * @param cool параметр cool машины
     */

    public Car(String name, Boolean cool){
        this.name=name;
        this.cool=cool;
    }

    /**
     *
     * @return возращает параметры класса Car
     */
    public String getAllParam(){
        return "Car{" +"\n"+
                "  \tname='" + name + '\'' +",\n"+
                "  \tcool=" + cool +",\n"+
                "}";
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":"+ "\"" + name + "\"" +
                ", \"cool\":" + cool +
                '}';
    }

    public String getName() {
        return name;
    }

    public Boolean getCool() {
        return cool;
    }
}