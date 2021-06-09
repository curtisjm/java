package DieProject;

public class Dice {
    private Die die1;
    private Die die2;

    public Dice() {
        die1 = new Die();
        die2 = new Die();
    }

    public Die getDie1() {
        return die1;
    }

    public Die getDie2() {
        return die2;
    }

    public void roll() {
        die1.roll();
        die2.roll();
    }

    public String toString() {
        String s = "Die 1 shows " + die1;
        s += "\nDie 2 shows " + die2;
        return s;
    }
}
