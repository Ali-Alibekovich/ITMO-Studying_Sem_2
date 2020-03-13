package CollectionWorker;
import ObjectSpecifications.HumanBeing;

import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

public class CollectionWorker implements Collection {
    Hashtable<Integer, HumanBeing> collection;
    private Date creationDate;
    Scanner sc;
    public CollectionWorker(Hashtable<Integer, HumanBeing> collection, Scanner sc){
        creationDate = new Date();
        this.collection=collection;
        this.sc=sc;
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
