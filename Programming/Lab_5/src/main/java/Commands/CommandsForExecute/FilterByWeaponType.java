package Commands.CommandsForExecute;

import BasicClasses.HumanBeing;
import BasicClasses.WeaponType;
import java.util.Hashtable;

/**
 * Класс отвечающий за команду filter_by_WeaponType
 */

public class FilterByWeaponType implements CommandIF  {
    Hashtable<Integer, HumanBeing> collection;

    public FilterByWeaponType(Hashtable<Integer, HumanBeing> collection){
        this.collection=collection;
    }

    @Override
    public void execute(String[] args) {
        try {
            for (Integer key : collection.keySet()) {
                if (collection.get(key).getWeaponType().equals(WeaponType.valueOf(args[1].toUpperCase()))) {
                    System.out.println(collection.get(key).getAllParam());
                }
            }
        }catch (IllegalArgumentException ex){
            System.out.println("Неверно введен аргумент команды");
        }
    }

    @Override
    public String infoCommand() {
        return "Команда filter_by_weapon_type weaponType - выводит элементы, значение поля weaponType которых равно заданному";
    }
}
