package Commands;

/**
 * Абстрактная команда: класс-отец всех команд.
 */
public abstract class Command {
    /**
     * Метоод - описание команды.
     */
    public abstract void aboutCommand();

    /**
     * Метод - исполнение команды.
     *
     * @param args - аругменты команды.
     */
    public abstract void execute(String[] args);
}
