public class Driver {

    public static void main(String[] args) {
        BankAccount myAcc = new BankAccount("Leece", "696969", 69000);
        System.out.println(myAcc);
        System.out.println();
        myAcc.setName("MatchaChaCha");
        System.out.println(myAcc.getName() + " has $" + myAcc.getBalance() + " in his account.");
        System.out.println();
        myAcc.setBalance(420000);
        System.out.println(myAcc);
    }
}
