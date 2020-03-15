package Commands.CommandBank;

import CollectionWorker.Collection;
import Commands.Command;

public class HistoryCommand implements Command {
    static String[] commandHistory = new String[6];
    static int i=0;
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
    public void runCommand() {
        for (String s : commandHistory){
            if(s!=null){
                System.out.println(s);
            }
        }
    }

    @Override
    public String toString() {
        return "Команда History";
    }
}
