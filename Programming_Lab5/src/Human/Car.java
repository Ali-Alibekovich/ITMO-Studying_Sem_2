package Human;

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

    Car(String name, boolean cool){
        this.name = Objects.requireNonNull(name,"invalid name");
        this.cool=cool;
    }
}
