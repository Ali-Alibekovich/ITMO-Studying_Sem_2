import HumanBeings.HumanBeing;
import HumanBeings.HumanReader;
import java.util.Hashtable;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashtable<Integer, HumanBeing> collectionn = new Hashtable<>();
        collectionn.put(19, HumanReader.readHuman(sc));
        System.out.println(collectionn.get(19));
    }
}