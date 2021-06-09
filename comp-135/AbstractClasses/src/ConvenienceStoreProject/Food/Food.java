package ConvenienceStoreProject.Food;

import ConvenienceStoreProject.StoreItem;

public class Food extends StoreItem {

    private double weight;

    public Food(String brand, String name, double price, boolean isRestricted, double weight) {
        super(brand, name, price, isRestricted);
        this.weight = weight;
    }
    public Food(String brand, String name, double price, double weight) {
        super(brand, name, price, StoreItem.DEFAULT_RESTRICTION);
        this.weight = weight;
    }

    // getters
    public double getWeight() {
        return weight;
    }

    // setters
    public void setWeight(double weight) {
        this.weight = weight;
    }



}
