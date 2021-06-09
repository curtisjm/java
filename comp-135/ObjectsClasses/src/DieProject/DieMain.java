package DieProject;

public class DieMain {
    public static void main(String[] args) {
        Die d1 = new Die();
        Die d2, d3;
        d2 = new Die();
        d3 = new Die();

        //System.out.println(d3.getFaceValue);
        d3.setFaceValue(-10);

        d1.roll();
        d1.roll();
        int currentValue = d1.getFaceValue();
        System.out.println(d1.getFaceValue());
        d1.getFaceValue();

        d1.setFaceValue(1);
        System.out.println(d1.getFaceValue());

        Dice pair1 = new Dice();  // Define a Dice Class.
        pair1.roll(); // Looks like Dice class has a roll as well. A Dice is a pair of Die objects.
        System.out.println(pair1);

        //d1.roll();
        //d1.roll();
        //d1.roll();
        d1.roll(3);
        d1.roll();
        System.out.println(d1);
        d1.roll();
        System.out.println(d1);
        d1.roll();
        System.out.println(d1);
        d1.roll();
        System.out.println(d1);

        pair1.roll();
        System.out.println(pair1);
    }

}
