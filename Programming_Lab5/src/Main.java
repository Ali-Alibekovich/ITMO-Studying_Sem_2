import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<Users> users = new HashSet<>();
        users.add(new Users(1,"Ali"));
        users.add(new Users(2,"Hussein"));
        Printer.PrintInFile(users);
        Writer.writer();
    }
}
