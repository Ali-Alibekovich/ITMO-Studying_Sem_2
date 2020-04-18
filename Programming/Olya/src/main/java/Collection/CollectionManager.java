package Collection;

import StoredClasses.Organization;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Менеджер коллекций: описывает команды, связанные с коллекцией.
 */

public class CollectionManager {
    /**
     * Поле - коллекция.
     */
    private static ArrayDeque<Organization> arrayDeque;
    /**
     * Поле - время инициализации коллекции.
     */
    private static LocalDateTime initializationDate;

    /**
     * Метод - инициализация коллекции.
     */
    public static void initializeCollection() {
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque<>();
            initializationDate = LocalDateTime.now();
        }
    }

    /**
     * Метод - возвращаение коллеции.
     *
     * @return array Deque - коллекция
     */
    public static ArrayDeque<Organization> getCollection() {
        return arrayDeque;
    }

    /**
     * Метод - запись организации в Json-файл.
     *
     * @param organization - записываемая организация.
     */
    public static void addJson(Organization organization) {
        organization.setId(IDGenerator.generateID());
        arrayDeque.add(organization);
    }

    /**
     * Метод - вывод информации о коллекции.
     */
    public static void information() {
        System.out.println("Тип коллекции: " + arrayDeque.getClass().getName() + ".\nДата инициализации: " + initializationDate + ".\nКоличество элементов: " + arrayDeque.size() + ".");
    }

    /**
     * Метод - вывод полной информации о коллекции и её элементах.
     */
    public static void fullInformation() {
        if (arrayDeque.size() == 0) {
            System.out.println("Коллекция пуста.");
        } else
            arrayDeque.forEach(CollectionUtils::organizationInfo);
    }

    /**
     * Метод - добавление организации в коллекцию.
     *
     * @param organization - добавляемая организация.
     */
    public static void addOrganization(Organization organization) {
        arrayDeque.add(organization);
    }

    /**
     * Метод - обновление значения элемента коллекции.
     *
     * @param newOrganization - новое значние.
     * @param ID              - ID обновляемого элемента.
     */
    public static void updateElement(Organization newOrganization, int ID) {
        arrayDeque.forEach(organization -> {
            if (organization.getId() == ID) {
                organization.setName(newOrganization.getName());
                organization.setCoordinates(newOrganization.getCoordinates());
                organization.setAnnualTurnover(newOrganization.getAnnualTurnover());
                organization.setType(newOrganization.getType());
                organization.setOfficialAddress(newOrganization.getOfficialAddress());
            }
        });
    }

    /**
     * Метод - удаление элемента.
     *
     * @param ID - ID удаляемого элемента.
     */
    public static void removeElement(int ID) {
        for (Organization organization : arrayDeque) {
            if (organization.getId() == ID) {
                arrayDeque.remove(organization);
                break;
            }
        }
    }

    /**
     * Метод - очищение коллекции.
     */
    public static void clearCollection() {
        arrayDeque.clear();
    }

    /**
     * Метод - удаление первого элемента коллекции с выводом.
     */
    public static void removeHead() {
        if (arrayDeque.size() != 0) {
            CollectionUtils.organizationInfo(arrayDeque.getFirst());
            arrayDeque.removeFirst();
        } else {
            System.out.println("В этой коллекции нет элементов.");
        }
    }

    /**
     * Метод - добавление элемента с условием минимальноести.
     *
     * @param organization добавляемый элемент.
     */
    public static void addIfMin(Organization organization) {
        if (arrayDeque.size() == 0) {
            addOrganization(organization);
        } else {
            boolean flag = true;
            for (Organization organization1 : arrayDeque) {
                if (organization1.compareTo(organization) < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) addOrganization(organization);
        }
    }

    /**
     * Метод - выбор элемента по годовому обороту.
     *
     * @param annualTurnover - годовой оборот, по которому выбор.
     */
    public static void filterByAnnualTurnover(Double annualTurnover) {
        arrayDeque.forEach(organization -> {
            if (organization.getAnnualTurnover().equals(annualTurnover)) {
                CollectionUtils.organizationInfo(organization);
            }
        });
    }

    /**
     * Метод - выбор элемента по началу имени.
     *
     * @param name - начало имени.
     */
    public static void filterStartsWithName(String name) {
        arrayDeque.forEach(organization -> {
            if (organization.getName().startsWith(name)) {
                CollectionUtils.organizationInfo(organization);
            }
        });
    }

    /**
     * Метод - вывод годовых оборотов в порядке убывания.
     */
    public static void printFieldDescendingAnnualTurnover() {
        Double[] arr = new Double[arrayDeque.size()];
        int i = 0;
        for (Organization organization : arrayDeque) {
            arr[i] = organization.getAnnualTurnover();
            i++;
        }
        Arrays.sort(arr);
        System.out.println("Годовые обороты компаний в порядке убывания: ");
        for (int ii = 0; ii < arr.length; ii++) {
            if (ii == arr.length - 1) {
                System.out.printf("%.3f. \n", arr[arr.length - (ii + 1)]);
            } else {
                System.out.printf("%.3f, ", arr[arr.length - (ii + 1)]);
            }
        }
    }
}