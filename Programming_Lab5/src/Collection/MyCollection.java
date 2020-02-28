package Collection;

import java.time.ZonedDateTime;
import java.util.Hashtable;

public class MyCollection extends Hashtable {
    private java.time.ZonedDateTime collectionCreationDate;
    public MyCollection() {
        this.collectionCreationDate = ZonedDateTime.now();
    }

    public ZonedDateTime getCollectionCreationDate() {
        return collectionCreationDate;
    }

    public void setCollectionCreationDate(ZonedDateTime collectionCreationDate) {
        this.collectionCreationDate = collectionCreationDate;
    }

    public Class<?> getTypeCollection(){
        return super.getClass().getSuperclass();
    }
    public void InformationOfHuman(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    private String toStringWithNull(Object o){
        if (o == null) return "отсутствует";
        return o.toString();
    }
}
