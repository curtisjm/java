
public class Driver {

    public static void main(String[] args) {
        CustomLinkedList customList = new CustomLinkedList();
        customList.insert(44);
        customList.insert(11);
        customList.insertHead(43);
        customList.insert(11);
        customList.insertHead(56);
        customList.insert(24);
        customList.insert(71);
        customList.insertAt(2, 12);

        System.out.println();
        System.out.println("List: ");
        customList.display();


        // right now it is setup to work with a Node return type. If you swap which parts are commented out, the errors will show up for the void version
        System.out.println();
        System.out.println("List after reverse: ");
        //customList.reverseR(customList.getHead());
        customList.setHead(customList.reverseR(customList.getHead()));
        customList.display();


    }

}
