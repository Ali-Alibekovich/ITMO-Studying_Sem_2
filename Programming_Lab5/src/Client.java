import Commands.CommandProcessing;
import Commands.ExitCommand;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandProcessing commandProcessing = new CommandProcessing();
        commandProcessing.readCommands(scanner);
    }
}
