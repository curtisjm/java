package LinkedQueueLab;

import GenEx3.LinkedStack;
import GenEx3.Stack;

public class QueueDriver {

    public static void main(String[] args) {
        QueueInterface<Integer> myStack = new LinkedQueue<>();
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
