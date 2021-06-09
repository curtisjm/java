package Lab.LabPt2;

public class MilitaryCadet {

    private String name;
    private int age;
    private double weight;
    private boolean valid;

    public MilitaryCadet(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        valid = isValid();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        try {
            if(age <= 40) {
                this.age = age;
            } else {
                throw new InvalidCadetException();
            }
        } catch(InvalidCadetException e) {
            System.out.println("Age must not be over 40");
        }
        valid = isValid();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        try {
            if(weight >= 40) {
                this.weight = weight;
            } else {
                throw new InvalidCadetException();
            }
        } catch(InvalidCadetException e) {
            System.out.println("Weight must not be less than 40 pounds");
        }
        valid = isValid();
    }

    public boolean getValid() {
        return valid;
    }

    private boolean isValid() {
        return age <= 40 && weight >= 40;
    }
}
