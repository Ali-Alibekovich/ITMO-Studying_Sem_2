import HumanBeings.HumanBeing;

import java.util.Hashtable;
import java.util.Scanner;

public class Client {
    private static boolean scriptStarted=false;
    public static void main(String[] args) {
        Hashtable<Integer, HumanBeing> humanBeingHashtable = new Hashtable<>();
        Scanner sc = new Scanner(System.in);
    }
    public static boolean getScriptRunning(){
        return scriptStarted;
    }
}