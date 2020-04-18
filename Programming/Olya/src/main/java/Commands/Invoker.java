package Commands;

import java.util.HashMap;

/**
 * Инвокер: исполнитель команд.
 */
public class Invoker {
    /**
     * Поле - коллекция команд.
     */
    private final HashMap<String, Command> commands = new HashMap<>();
    /**
     * Поле - история семи последних команд.
     */
    private String[] commandHistory = new String[7];
    /**
     * Поле - вспомогательная переменная для изменения истории команд.
     */
    private static int historyPointer;

    /**
     * Метод - регистрация команды.
     *
     * @param name    - имя команды.
     * @param command - команда.
     */
    public void register(String name, Command command) {
        commands.put(name, command);
    }

    /**
     * Метод - выполнение команды.
     *
     * @param name - имя команды.
     */
    public void executeCommand(String[] name) {
        try {
            if (name.length > 0) {
                Command command = commands.get(name[0]);
                command.execute(name);
                addCommandToHistory(name[0]);
            } else {
                System.out.println("Вы не ввели команду.");
            }
        } catch (IllegalStateException | NullPointerException e) {
            if (!name[0].equals("")) {
                System.out.println("Не существует команды '" + name[0] + "'. Для справки используйте команду\u001B[36m help\u001B[0m.");
            }
        }
    }

    /**
     * Геттер коллекции команд.
     *
     * @return коллекция команд.
     */
    public HashMap<String, Command> getCommands() {
        return commands;
    }

    /**
     * Метод - добавление команды в историю.
     *
     * @param onlyName - имя добавляемой команды.
     */
    public void addCommandToHistory(String onlyName) {
        for (int i = 0; i < 7; i++) {
            if (commandHistory[i] == null) {
                historyPointer = i;
                break;
            }
        }
        if (historyPointer < 7) {
            commandHistory[historyPointer] = onlyName;
        } else {
            for (int i = 0; i < 6; i++) {
                commandHistory[i] = commandHistory[i + 1];
            }
            commandHistory[6] = onlyName;
        }
    }

    /**
     * Геттер истории команд.
     *
     * @return история команд.
     */
    public String[] getCommandHistory() {
        return commandHistory;
    }
}