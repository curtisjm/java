
public class Driver {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(40);
        bst.insert(25);
        bst.insert(78);
        bst.insert(10);
        bst.insert(3);
        bst.insert(32);
        bst.insert(55);
        bst.insert(93);

        System.out.println("Print In Order: ");
        bst.printInOrder();

        System.out.println("Print Pre Order: ");
        bst.printPreOrder();

        System.out.println("Print Post Order: ");
        bst.printPostOrder();

        System.out.println("Max Value: " + bst.findMaximum());
        System.out.println("Min Value: " + bst.findMinimum());

        bst.delete(78);
        bst.printInOrder();

    }
}
