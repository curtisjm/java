
public abstract class StoreItem implements Comparable<StoreItem> {

    private String brand, name;
    private boolean restricted;
    private double price;

    public StoreItem(String name, String brand, double price, boolean restricted) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.restricted = restricted;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0) {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "\nBrand: " + brand + "\nName: " + name + "\nPrice: $" + price + (restricted ? "\nIs it restricted? " + restricted : "");
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof StoreItem) {
            StoreItem otherItem = (StoreItem) obj;
            return name.equalsIgnoreCase(otherItem.name) &&
                    brand.equalsIgnoreCase(otherItem.brand);
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(StoreItem otherItem) {
        if(brand.equalsIgnoreCase(otherItem.brand)) {
            return name.compareToIgnoreCase(otherItem.name);
        } else {
            return brand.compareToIgnoreCase(otherItem.brand);
        }
    }

    public abstract void orderItem();
}
