import java.util.Arrays;

public class ArraysLabExercise {

    public static void sum50(int[] numbers) {
        int sum = 0;
        for(int i = 0; i < 50; i++) {
            numbers[i] = i + 1;
            sum += numbers[i];
        }
        System.out.println(sum);
        System.out.println();
    }

    public static void from1T0100(int[] numbers){
        for(int i =0;i<100;i++){
            numbers[i]=i+1;
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
        System.out.println();
    }


    public static void multiples3(int[] numbers){
        for(int i = 0;i<100;i++){
            numbers[i]=3*i;
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
        System.out.println();
    }

    public static void odd(int[] numbers){
        for(int i = 1; i < 100; i++) {
            if(numbers[i] % 2 != 0) {
                System.out.print(numbers[i] + ", ");
            }
        }
        System.out.println();
        System.out.println();
    }

    public static void random(){
        boolean[] randoms = new boolean[100];
        int temp=0;
        for(int i=0;i<100;i++){
            temp=(int)(Math.random()*100);
            if(temp>50){
                randoms[i]= true;
            }else randoms[i]= false;
            System.out.print(randoms[i]+", ");
        }
        System.out.println();
        System.out.println();
    }

    public static void main (String[] args) {
        int[] numbers = new int[100];
        for(int i = 0; i < 100; i++) {
            numbers[i] = i + 1;
        }

        System.out.println("Sum of the first 50 numbers");
        sum50(numbers);
        System.out.println("Numbers from 1 to 100");
        from1T0100(numbers);
        System.out.println("First 50 odd numbers");
        odd(numbers);
        System.out.println("First 100 multiples of 3");
        multiples3(numbers);
        System.out.println("100 random true or false");
        random();

    }
}
