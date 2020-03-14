package CollectionWorker;
import ObjectSpecifications.HumanBeing;

import java.util.Date;
import java.util.Hashtable;


public class CollectionWorker implements Collection {
    Hashtable<Integer, HumanBeing> collection;
    private Date creationDate;
    public CollectionWorker(Hashtable<Integer, HumanBeing> collection){
        creationDate = new Date();
        this.collection=collection;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String getCollectionType() {
        return collection.getClass().getSimpleName();
    }

    @Override
    public int getSize() {
        return collection.size();
    }

}
