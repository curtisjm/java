
public class PersonalItem extends StoreItem {

    public PersonalItem(String name, String brand, double price, boolean restricted) {
        super(name, brand, price, restricted);
    }

    @Override
    public void orderItem() {
        System.out.println("Order from distributor: " + getBrand() + " " + getName());
    }

    @Override
    public String toString() {
        return super.toString() + "\n Personal Item";
    }
}
