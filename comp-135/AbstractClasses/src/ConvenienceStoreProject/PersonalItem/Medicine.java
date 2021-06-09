package ConvenienceStoreProject.PersonalItem;

import ConvenienceStoreProject.Interfaces.Expirable;
import ConvenienceStoreProject.StoreItem;

public class Medicine extends StoreItem implements Expirable {

    public Medicine() {
        super();
    }

    public Medicine(String brand, String name, double price, boolean isRestricted) {
        super(brand, name, price, isRestricted);

    }

    @Override
    public void checkExpirationStatus() {

    }
}
