package ConvenienceStoreProject;

import InterfacesEx.AudioItem;

public abstract class StoreItem implements Comparable<StoreItem> {

    private String brand;
    private String name;
    private double price;
    private boolean isRestricted;

    public static final boolean DEFAULT_RESTRICTION = false;


    public StoreItem() {
    }
    public StoreItem(String brand, String name, double price, boolean isRestricted) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        // change later
        this.isRestricted = isRestricted;
    }
    public StoreItem(String brand, String name, double price) {
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }
    public String getName() {
        return name;
    }
    public double price() {
        return price;
    }
    public boolean isRestricted() {
        return isRestricted;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String s = "Name: " + name;
        s+= "\nBrand: " + brand;
        s+= "\nPrice: $" + price;
        s+= "Is it restrticted? " + isRestricted;
        return s;
    }

    @Override
    public int compareTo(StoreItem otherItem) {
        if(brand.equalsIgnoreCase(otherItem.brand)) {
            if(name.equalsIgnoreCase(otherItem.name)) {
                return Double.compare(price, otherItem.price);
            } else {
                return -1;
            }
        } else {
            return brand.compareToIgnoreCase(otherItem.brand);
        }
    }

}
//All items are described by a brand, name, price, and whether or not their sale is restricted.
