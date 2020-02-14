import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Writer {
    public Writer() throws FileNotFoundException {
        Scanner out = new Scanner(new File("src/Data.txt"));
        while (out.hasNextLine()){
            System.out.println(out.nextLine());
        }
    }
}
