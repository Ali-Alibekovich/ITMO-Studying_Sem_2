import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Printer {
    public static void PrintInFile(Set<Users> users) throws IOException {
        PrintWriter in = new PrintWriter(new FileWriter("src/Data.txt",true));
        for (Users user:users){
            in.write(user+"\n");
        }
        in.close();
    }
}
