package Collection;

import BasicClasses.HumanBeing;

import java.util.Date;
import java.util.Hashtable;
/**
 * Класс отвечающий за коллекцию
 */

public class CollectionManager {
    private Hashtable<Integer, HumanBeing> collection;
    private Date date;

    /**
     * @param collection принимает коллекцию Hashtable для HumanBeing
     */
    public CollectionManager(Hashtable<Integer,HumanBeing> collection){
        this.collection=collection;
        this.date=new Date();
    }

    public String getCollectionType() {
        return collection.getClass().getSimpleName();
    }


    public int getSize() {
        return collection.size();
    }

    public Hashtable<Integer, HumanBeing> getCollection() {
        return collection;
    }

    public Date getDate() {
        return date;
    }

}
