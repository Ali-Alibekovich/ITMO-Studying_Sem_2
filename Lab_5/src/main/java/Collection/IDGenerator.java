package Collection;

import java.util.HashSet;
import java.util.Random;

/**
 * Класс отвечающий за генерацию ID
 */

public class IDGenerator  {
    private static HashSet<Integer> hashSetId = new HashSet<>();

    public static Integer generateID(){
        Integer id = new Random().nextInt(Integer.MAX_VALUE);

        if(hashSetId.contains(id)){
            while (hashSetId.contains(id)){
                id= new Random().nextInt(Integer.MAX_VALUE);
            }
        }
        hashSetId.add(id);
        return id;
    }

    /**
     * @param ID принимает ID с пользователя
     * @return если такой ID сущетсвует, то возращает новый рандомный ID
     */
    public static Integer generateID(Integer ID) {
        Integer id = ID;

        if (hashSetId.contains(id)) {
            while (hashSetId.contains(id)) {
                id = new Random().nextInt(Integer.MAX_VALUE);
            }
        }

        hashSetId.add(id);
        return id;
    }
}
