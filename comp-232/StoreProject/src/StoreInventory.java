import java.util.ArrayList;
import java.util.Collections;

public class StoreInventory {

    public static void main(String[] args) {
        ArrayList<StoreItem> inventoryList = new ArrayList<>();

        inventoryList.add(new PerishableFood("Macintosh Apples", "Farmer Tom's", 2.99, 160));
        inventoryList.add(new PerishableFood("Cheddar Cheese", "Byrne Dairy", 5.99, 546));
        inventoryList.add(new NonPerishableFood("Crackers", "Ritz", 1.99, 860));
        inventoryList.add(new NonPerishableFood("Crackers", "Saltines", 1.99, 860));
        inventoryList.add(new Beverage("Milk", "Byrne Dairy", 5.99, false, Beverage.ContainerType.CARDBOARD));
        inventoryList.add(new Beverage("Juice", "V8", 1.99, false, Beverage.ContainerType.PLASTIC));
        inventoryList.add(new Soda("Diet Pepsi", "PepsiCola", 5.99, Beverage.ContainerType.ALUMINUM));
        inventoryList.add(new Beer("IPA", "Brewertons", 18.99, Beverage.ContainerType.GLASS));
        inventoryList.add(new Medicine("Cold and Flu", "Sudafed", 8.99, true));
        inventoryList.add(new Medicine("Pain Reliever", "Tylenol", 6.99, false));
        inventoryList.add(new PersonalCareItem("Shampoo", "Paul Mitchell", 18.99));

        System.out.println("\n-- Unsorted Inventory --");
        for(StoreItem item : inventoryList) {
            System.out.println(item);
        }

        Collections.sort(inventoryList);
        System.out.println("\n-- Sorted Inventory --");
        for(StoreItem item : inventoryList) {
            System.out.println(item);
        }

        System.out.println("\n-- Expirations --");
        for(StoreItem item : inventoryList) {
            if(item instanceof Expirable) {
                ((Expirable) item).checkExpirationStatus();
            }
        }

        System.out.println("\n-- Restricted Items --");
        for(StoreItem item : inventoryList) {
            if(item.isRestricted()) {
                System.out.println(item);
            }
        }

        System.out.println("\n-- Beverages with Aluminum Container --");
        for(StoreItem item : inventoryList) {
            if(item instanceof Beverage) {
                if(((Beverage) item).getContainerType().equals(Beverage.ContainerType.ALUMINUM)) {
                    System.out.println(item);
                }
            }
        }

        System.out.println("\n-- Taxable Items --");
        for(StoreItem item : inventoryList) {
            if(item instanceof Taxable) {
                double p = ((Taxable) item).taxedPrice();
                System.out.println(item);
                System.out.println(" Taxed Price: $" + p);
            }
        }
    }
}
