import Collection.CollectionManager;
import Commands.Invoker;
import Commands.Receiver;
import Commands.SpecificCommands.*;

import java.util.Scanner;

/**
 * Консольный менеджер.
 */
public class ConsoleManager {
    void interactive() {
        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver(invoker);

        CollectionManager.initializeCollection();
        invoker.register("help", new Help(receiver));
        invoker.register("info", new Info(receiver));
        invoker.register("show", new Show(receiver));
        invoker.register("add", new Add(receiver));
        invoker.register("update", new Update(receiver));
        invoker.register("remove_by_id", new RemoveById(receiver));
        invoker.register("clear", new Clear(receiver));
        invoker.register("save", new Save(receiver));
        invoker.register("execute_script", new ExecuteScript(receiver));
        invoker.register("exit", new Exit(receiver));
        invoker.register("remove_head", new RemoveHead(receiver));
        invoker.register("add_if_min", new AddIfMin(receiver));
        invoker.register("history", new History(receiver));
        invoker.register("filter_by_annual_turnover", new FilterByAnnualTurnover(receiver));
        invoker.register("filter_starts_with_name", new FilterStartsWithName(receiver));
        invoker.register("print_field_descending_annual_turnover", new PrintFieldDescendingAnnualTurnover(receiver));

        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                invoker.executeCommand(sc.nextLine().trim().split(" "));
            }
        }
    }
}