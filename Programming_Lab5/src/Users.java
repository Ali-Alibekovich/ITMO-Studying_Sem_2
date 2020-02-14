import java.util.Objects;

public class Users<T> {
    String name;
    int id;
    Users(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users<?> users = (Users<?>) o;
        return id == users.id &&
                Objects.equals(name, users.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
