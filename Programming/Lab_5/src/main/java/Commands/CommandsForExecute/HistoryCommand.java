package Commands.CommandsForExecute;

/**
 * Класс отвечающий за команду history
 */


public class HistoryCommand implements CommandIF {
    private static String[] commandHistory = new String[6];
    private static int i=0;
    @Override
    public void execute(String[] s) {
        for (String k : commandHistory){
            if(k!=null){
                System.out.println(k);
            }
        }
    }

    @Override
    public String infoCommand() {
        return "Команда history - выводит историю введеных команд";
    }

    public static void saveCommand(String command) {
        if(i>=6){
            int y=5;
            for(int i=4;i>=0;i--){
                commandHistory[y]=commandHistory[i];
                y--;
            }
            commandHistory[0]=command;
        }else {
            commandHistory[i] = command;
            i++;
        }
    }
    @Override
    public String toString() {
        return "Команда History";
    }
}
