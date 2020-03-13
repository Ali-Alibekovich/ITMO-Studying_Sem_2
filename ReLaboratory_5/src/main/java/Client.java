import ObjectSpecifications.HumanBeing;
import ObjectSpecifications.HumanReader;

import java.util.Hashtable;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Hashtable<Integer, HumanBeing> collection = new Hashtable<>();
        Scanner sc = new Scanner(System.in);
        collection.put(1,new HumanReader().readHuman(sc));
    }
}
