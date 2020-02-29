
import HumanBeings.HumanBeing;
import HumanBeings.HumanReader;

import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        Hashtable<Integer, HumanBeing> collectionn = new Hashtable<>();
        /*
        Дописать условие при возращении HumanReader'ом null'а
         */
        collectionn.put(19, HumanReader.readHuman(sc));
        System.out.println(collectionn.get(19));

    }
}