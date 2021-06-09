package GenEx3;

public class StackDriver {

    public static void main(String[] args) {
        Stack <Integer> myStack = new LinkedStack<Integer>();
        myStack.push(30);
        myStack.push(435);
        myStack.push(675);
        myStack.push(350);
        myStack.push(340);
        myStack.push(190);

        System.out.println("Size of myStack: " + myStack.size());
        // prints last in first
        System.out.println("MyStack has in it: ");
        for(Integer i : myStack)
            System.out.println(i);
        System.out.println();

        myStack.pop();
        System.out.println("Size of myStack: " + myStack.size());
        System.out.println("MyStack has in it: ");
        for(Integer i : myStack)
            System.out.println(i);
    }
}
