import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class Users{
    String name;
    int id;
    Users(int id,String name) throws IOException {
        this.id=id;
        this.name=name;
        new Printer(this.toString());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
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
