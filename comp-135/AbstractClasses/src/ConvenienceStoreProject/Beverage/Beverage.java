package ConvenienceStoreProject.Beverage;

import ConvenienceStoreProject.StoreItem;

public class Beverage extends StoreItem {

    private String container;

    public Beverage(String name, String brand, double price, boolean isRestricted, String container) {
        super(name, brand, price, isRestricted);
        this.container = container;

    }

    // getters
    public String getContainer() {
        return container;
    }

    // setters

    public void setContainer(String container) {
        this.container = container;
    }
}
