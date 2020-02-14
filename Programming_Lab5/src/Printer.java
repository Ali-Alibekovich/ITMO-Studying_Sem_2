import java.io.*;
import java.util.Scanner;

public class Printer {
    public Printer(String o) throws IOException {
        PrintWriter in = new PrintWriter(new FileWriter("src/Data.txt",true));
        in.append(o).append("\n");
        in.close();
    }
}
