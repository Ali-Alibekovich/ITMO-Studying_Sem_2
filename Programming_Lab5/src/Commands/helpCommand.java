package Commands;

public class helpCommand implements InterfaceCommand {
    @Override
    public void runCommand() {
        System.out.println("•\thelp : вывести справку по доступным командам\n" +
                "•\tinfo : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "•\tshow : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "•\tinsert key {element} : добавить новый элемент с заданным ключом\n" +
                "•\tupdate id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "•\tremove_key key : удалить элемент из коллекции по его ключу\n" +
                "•\tclear : очистить коллекцию\n" +
                "•\tsave : сохранить коллекцию в файл\n" +
                "•\texecute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "•\texit : завершить программу (без сохранения в файл)\n" +
                "•\tremove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                "•\tremove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "•\thistory : вывести последние 6 команд (без их аргументов)\n" +
                "•\tfilter_by_weapon_type weaponType : вывести элементы, значение поля weaponType которых равно заданному\n" +
                "•\tprint_ascending : вывести элементы коллекции в порядке возрастания\n" +
                "•\tprint_unique_car car : вывести уникальные значения поля car\n");
    }
}
