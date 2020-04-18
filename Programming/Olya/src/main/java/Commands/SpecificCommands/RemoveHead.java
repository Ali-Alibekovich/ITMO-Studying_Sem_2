package Commands.SpecificCommands;

import Commands.Command;
import Commands.Receiver;

/**
 * Команда remove_head.
 */
public class RemoveHead extends Command {
    private final Receiver receiver;

    public RemoveHead(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("О команде\u001B[36m remove_head\u001B[0m: первый элемент коллекции выводится и удаляется.");
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Неправильный формат команды! Команда не будет выполнена.");
        } else {
            receiver.remove_head();
        }
    }
}

