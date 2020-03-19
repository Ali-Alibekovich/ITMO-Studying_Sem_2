package ObjectSpecifications;

import java.util.Objects;

public class Car {
    private String name; //Поле может быть null
    private boolean cool;

    public String getName() {
        return name;
    }

    public boolean isCool() {
        return cool;
    }

    public Car(String name, boolean cool){
        this.name = Objects.requireNonNull(name,"invalid name");
        this.cool=cool;
    }
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
}
