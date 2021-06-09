package CustomerProject;

public class Address {

    private String building;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String building, String street, String city, String state, String zip) {
        this.building = building;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getBuilding() {
        return building;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return building + " " + street + " " + city + " " + state + " " + zip;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Address) {
            Address otherAddress = (Address) obj;
            boolean sameBuilding, sameStreet, sameCity, sameState, sameZip;
            sameBuilding = this.building.equalsIgnoreCase(otherAddress.building);
            sameStreet = this.street.equalsIgnoreCase(otherAddress.street);
            sameCity = this.city.equalsIgnoreCase(otherAddress.city);
            sameState = this.state.equalsIgnoreCase(otherAddress.state);
            sameZip = this.zip.equalsIgnoreCase(otherAddress.zip);
            return sameBuilding && sameStreet && sameCity && sameState && sameZip;
        } else {
            return false;
        }
    }
}
