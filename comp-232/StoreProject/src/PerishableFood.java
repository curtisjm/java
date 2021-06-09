
public class PerishableFood extends Food implements Expirable {

    public PerishableFood(String name, String brand, double price, int weight) {
        super(name, brand, price, weight);
    }

    @Override
    public void orderItem() {
        System.out.println("Order from local farm please " + getBrand() + " " + getName());
    }

    @Override
    public void checkExpirationStatus() {
        System.out.println("Check the status of " + getName());
    }
}
