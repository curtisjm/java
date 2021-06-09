package ConvenienceStoreProject.Food;

import ConvenienceStoreProject.Interfaces.Expirable;
import ConvenienceStoreProject.StoreItem;

public class PerishableFood extends Food implements Expirable {

    public PerishableFood(String name, String brand, double price, boolean isRestricted, double weight) {
        super(name, brand, price, isRestricted, weight);
    }

    public PerishableFood(String name, String brand, double price, double weight) {
        super(name, brand, price, weight);
    }


    @Override
    public void checkExpirationStatus() {
        System.out.println("test");
    }
}
