package Commands;

import Collection.CollectionManager;
import Collection.CollectionUtils;
import Commands.SpecificCommands.ExecuteScript;
import Commands.Utils.Creator;
import Commands.Utils.ParserJson;
import StoredClasses.Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Ресивер: описывает логику команд.
 */
public class Receiver {
    /**
     * Поле - инвокер.
     */
    private final Invoker invoker;

    /**
     * Конструктор.
     *
     * @param invoker - инвокер.
     */
    public Receiver(Invoker invoker) {
        this.invoker = invoker;
    }

    /**
     * Логика команды help.
     */
    public void help() {
        System.out.println("Информация о командах:");
        invoker.getCommands().forEach((name, command) -> command.aboutCommand());
    }

    /**
     * Логика команды info.
     */
    public void info() {
        CollectionManager.information();
    }

    /**
     * Логика команды show.
     */
    public void show() {
        CollectionManager.fullInformation();
    }

    /**
     * Логика команды add.
     */
    public void add() {
        CollectionManager.addOrganization(Creator.createOrganizationFromConsole());
        System.out.println("Организация добавлена в коллекцию.");
    }

    /**
     * Логика команды update.
     */
    public void update(String ID_s) {
        Integer ID;
        try {
            ID = Integer.parseInt(ID_s);
            if (CollectionUtils.doesExist(ID)) {
                CollectionManager.updateElement(Creator.createOrganizationFromConsole(), ID);
                System.out.println("Организация обновлена.");
            } else {
                System.out.println("В коллекции нет организации с таким ID.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID был введён некорректно. Команда не выполнена.");
        }
    }

    /**
     * Логика команды remove_by_id.
     */
    public void remove_by_id(String ID_s) {
        Integer ID;
        try {
            ID = Integer.parseInt(ID_s);
            if (CollectionUtils.doesExist(ID)) {
                CollectionManager.removeElement(ID);
                System.out.println("Элемент удалён.");
            } else {
                System.out.println("Такого элемента нет в коллекции.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Неправильный аргумент команды! Команда не будет выполнена.");
        }
    }

    /**
     * Логика команды clear.
     */
    public void clear() {
        CollectionManager.clearCollection();
        System.out.println("Коллекция очищена.");
    }

    /**
     * Логика команды save.
     */
    public void save() {
        ParserJson.collectionToJson();
        System.out.println("Коллекция сохранена в файл.");
    }

    /**
     * Логика команды execute_script.
     */
    public void execute_script(String path) {
        String[] line;
        String command;
        String[] parameters = new String[10];
        String id;
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(path)); Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine().trim().split(" ");
                if (line[0].matches("add|add_if_min")) {
                    command = line[0];
                    try {
                        String parameter = scanner.nextLine();
                        for (int i = 1; i < 11; i++) {
                            if (parameter != null) {
                                parameters[i - 1] = parameter;
                                if (i != 10) {
                                    parameter = scanner.nextLine();
                                }
                            } else {
                                System.out.println("Невозможно создать объект из-за нехватки параметров.");
                                break;
                            }
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Не хватает аргументов! Невозможно выполнить скрипт.");
                        break;
                    } catch (NoSuchElementException e) {
                        System.out.println("Не хватает аргументов!");
                        break;
                    }
                    Organization organization = Creator.createOrganizationFromScript(parameters);
                    switch (command) {
                        case "add":
                            CollectionManager.addOrganization(organization);
                            System.out.println("Коллекция добавлена.");
                            break;
                        case "add_if_min":
                            CollectionManager.addIfMin(organization);
                            System.out.println("Коллекция добавлена.");
                            break;
                    }
                } else {
                    if (line[0].equals("update")) {
                        command = line[0];
                        if (line[1] != null) {
                            try {
                                id = line[1];
                            } catch (NumberFormatException e) {
                                System.out.println("Неправильный формат аргумента.");
                                break;
                            }
                        } else {
                            System.out.println("Невозможно создать объект из-за нехватки параметров.");
                            break;
                        }
                        try {
                            String parameter = scanner.nextLine();
                            for (int i = 2; i < 12; i++) {
                                if (parameter != null) {
                                    parameters[i - 2] = parameter;
                                    if (i != 11) {
                                        parameter = scanner.nextLine();
                                    }
                                } else {
                                    System.out.println("Невозможно создать объект из-за нехватки параметров.");
                                    break;
                                }
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Не хватает аргументов! Невозможно выполнить скрипт.");
                            break;
                        } catch (NoSuchElementException e) {
                            System.out.println("Не хватает аргументов!");
                        }
                        Organization organization = Creator.createOrganizationFromScript(parameters);
                        CollectionManager.updateElement(organization, Integer.parseInt(id));
                    } else {
                        if (line[0].equals("execute_script") && line[1].equals(ExecuteScript.getPath())) {
                            System.out.println("Пресечена попытка рекурсивного вызова скрипта.");
                        } else {
                            invoker.executeCommand(line);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось найти файл");
        } catch (IOException e) {
            System.out.println("Что-то пошло не так!");
        }
    }

    /**
     * Логика команды exit.
     */
    public void exit() {
        System.out.println("Завершение работы программы.");
        System.exit(0);
    }

    /**
     * Логика команды remove_head.
     */
    public void remove_head() {
        CollectionManager.removeHead();
    }

    /**
     * Логика команды add_if_min.
     */
    public void add_if_min() {
        CollectionManager.addIfMin(Creator.createOrganizationFromConsole());
        System.out.println("Команда выполнена.");
    }

    /**
     * Логика команды history.
     */
    public void history() {
        if (invoker.getCommandHistory()[0] == null) {
            System.out.println("История пуста.");
        } else {
            for (int i = 0; i < 7; i++) {
                if (invoker.getCommandHistory()[i] != null) {
                    System.out.println(invoker.getCommandHistory()[i] + " ");
                }
            }
        }
    }

    /**
     * Логика команды filter_by_annual_turnover.
     */
    public void filter_by_annual_turnover(String annualTurnover_s) {
        Double annualTurnover;
        try {
            annualTurnover = Double.parseDouble(annualTurnover_s);
            CollectionManager.filterByAnnualTurnover(annualTurnover);
        } catch (NumberFormatException e) {
            System.out.println("Неправильный аргумент команды! Команда не будет выполнена.");
        }
    }

    /**
     * Логика команды filter_starts_with_name.
     */
    public void filter_starts_with_name(String name) {
        CollectionManager.filterStartsWithName(name);
    }

    /**
     * Логика команды print_field_descending_annual_turnover.
     */
    public void print_field_descending_annual_turnover() {
        CollectionManager.printFieldDescendingAnnualTurnover();
    }
}