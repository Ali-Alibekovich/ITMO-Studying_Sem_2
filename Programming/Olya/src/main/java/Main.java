import Commands.Utils.ParserJson;

/**
 * Главный класс приложения.
 */
public class Main {
    public static String fileName;

    public static void main(String[] args) {
        if (args.length == 0 || args[0].trim().length() == 0) {
            System.out.println("Вы не ввели название файла, из которого нужно загрузить коллекцию!");
            System.exit(1);
        }
        System.out.println("Нужна помощь? Используйте команду\u001B[36m help\u001B[0m.");
        fileName = args[0];
        ParserJson.setFileName(fileName);
        ParserJson.fromJsonToCollection();
        ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.interactive();
    }
}