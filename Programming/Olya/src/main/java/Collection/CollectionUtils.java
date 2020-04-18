package Collection;

import StoredClasses.Organization;

/**
 * Утилиты для работы с коллецией.
 */
public class CollectionUtils {
    /**
     * Метод - вывод полной информации об организации.
     *
     * @param organization - организация.
     */
    public static void organizationInfo(Organization organization) {
        System.out.println("ID: " + organization.getId() + ".");
        System.out.println("Название организации: " + organization.getName());
        System.out.println("Координаты: X=" + organization.getCoordinates().getX() + ", Y=" + organization.getCoordinates().getY() + ".");
        System.out.println("Время создания: " + organization.getCreationDate() + ".");
        System.out.println("Годовой оборот организации: " + organization.getAnnualTurnover() + ".");
        System.out.println("Тип организации: " + organization.getType() + ".");
        System.out.println("Адрес организации: улица " + organization.getOfficialAddress().getStreet() + ", почтовый индекс " + organization.getOfficialAddress().getZipCode() + ", город " + organization.getOfficialAddress().getTown().getName() + " (X=" + organization.getOfficialAddress().getTown().getX() + ", Y=" + organization.getOfficialAddress().getTown().getY() + ").");
    }

    /**
     * Метод - проверка на существование организации с данным ID.
     *
     * @param ID - данный ID.
     * @return правда/ложь
     */
    public static boolean doesExist(int ID) {
        for (Organization organization : CollectionManager.getCollection()) {
            return organization.getId() == (ID);
        }
        return false;
    }
}
