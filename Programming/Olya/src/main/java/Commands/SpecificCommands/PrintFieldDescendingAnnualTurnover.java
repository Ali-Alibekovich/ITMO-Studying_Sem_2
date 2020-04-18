package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда print_field_descending_annual_turnover.
 */
public class PrintFieldDescendingAnnualTurnover extends Command {
    private final Receiver receiver;

    public PrintFieldDescendingAnnualTurnover(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m print_field_descending_annual_turnover\u001B[0m: выводятся значения поля annualTurnover всех элементов в порядке убывания.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.print_field_descending_annual_turnover();
        }
    }
}
