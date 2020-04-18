package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда filter_by_annual_turnover.
 */
public class FilterByAnnualTurnover extends Command {
    private final Receiver receiver;

    public FilterByAnnualTurnover(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m filter_by_annual_turnover\u001B[0m: выводятся элементы, значение поля annualTurnover которых равно заданному.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.filter_by_annual_turnover(args[1]);
        }
    }
}
