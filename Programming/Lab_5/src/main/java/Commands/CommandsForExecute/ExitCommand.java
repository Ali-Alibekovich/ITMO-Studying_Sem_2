package Commands.CommandsForExecute;

/**
 * Класс отвечающий за команду exit
 */


public class ExitCommand implements CommandIF {

    @Override
    public void execute(String[] s) {
        System.out.println("Работа с консолью завершена");
        System.exit(0);
    }

    @Override
    public String infoCommand() {
        return "Команда exit завершает программу (без сохранения в файл)";
    }
}
