
import HumanBeings.HumanBeing;
import HumanBeings.HumanReader;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        HumanReader humanReader = new HumanReader();
        HumanReader.readHuman(sc);

    }
}