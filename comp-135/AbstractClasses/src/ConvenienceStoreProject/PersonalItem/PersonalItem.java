package ConvenienceStoreProject.PersonalItem;

import ConvenienceStoreProject.Interfaces.Taxable;
import ConvenienceStoreProject.StoreItem;

public class PersonalItem extends StoreItem implements Taxable {
    // variables
    // ???

    // constructors
    public PersonalItem() {
        super();
    }

    public PersonalItem(String brand, String name, double price, boolean isRestricted) {
        super(brand, name, price, isRestricted);
    }

    @Override
    public double taxedPrice() {
        return getPrice() + (taxRate )
    }

    // getters

    // setters

}
