import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Writer {
    public static void writer() throws FileNotFoundException {
        Scanner out = new Scanner(new File("src/Data.txt"));
        while (out.hasNextLine()){
            System.out.println(out.nextLine());
        }
    }
}
