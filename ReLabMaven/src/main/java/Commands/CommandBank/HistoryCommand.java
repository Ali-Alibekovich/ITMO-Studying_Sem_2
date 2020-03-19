package Commands.CommandBank;

import Commands.Command;

public class HistoryCommand implements Command {
    private static String[] commandHistory = new String[6];
    private static int i=0;
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
        /*
        Реализация через жопу(
         */
    }
    @Override
    public void runCommand(String[] s) {
        for (String k : commandHistory){
            if(k!=null){
                System.out.println(k);
            }
        }
    }

    @Override
    public String toString() {
        return "Команда History";
    }
}
