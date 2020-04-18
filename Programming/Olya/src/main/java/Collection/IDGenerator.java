package Collection;

import java.util.HashSet;
import java.util.Random;

/**
 * Генератор ID организаций.
 */
public class IDGenerator {
    /**
     * Поле - коллекция ID.
     */
    private static HashSet<Integer> IDs = new HashSet<>();

    /**
     * Метод - генерация ID.
     *
     * @return ID.
     */
    public static int generateID() {
        Integer id = new Random().nextInt(Integer.MAX_VALUE);
        if (IDs.contains(id)) {
            while (IDs.contains(id)) {
                id = new Random().nextInt(Integer.MAX_VALUE);
            }
        }
        IDs.add(id);
        return id;
    }
}
