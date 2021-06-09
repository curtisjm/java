
public class CustomLinkedList {

    // points to beginning
    private Node head;

    public CustomLinkedList() {

    }

    public void insert(int data) {
        Node newNode = new Node(data);
        // if list is empty
        if(this.head == null) {
            head = newNode;
        // if list has some items in it
        } else {
            // traverse the list and then link newNode
            Node currentNode = head;
            while(currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }

    public void insertHead(int data) {
        Node newNode = new Node(data);
        newNode.setNextNode(head);
        head = newNode;
    }

    public void insertAt(int index, int data) {
        Node newNode = new Node(data);
        Node currentNode = head;
        for(int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNextNode();
        }
        newNode.setNextNode(currentNode.getNextNode());
        currentNode.setNextNode(newNode);
    }

    public int length() {
        Node currentNode = head;
        int len = 0;
        while(currentNode != null) {
            len++;
            currentNode = currentNode.getNextNode();
        }
        return len;
    }

    public void deleteAt(int index) {
        Node currentNode = head;
        if(currentNode == null) {
            return;
        }
        int len = length();
        if(len == 0 || len < index) {
            return;
        }
        if(index != 0) {
            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNextNode();
            }
        } else {
            head = currentNode.getNextNode();
        }
        length();
        currentNode.setNextNode(currentNode.getNextNode().getNextNode());
    }

    public int getNth(int index) {
        Node currentNode = head;
        for(int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getData();
    }

    public void removeDuplicates() {
        Node currentNode = head;
        Node nextNode;
        if(currentNode == null) {
            return;
        }
        while(currentNode.getNextNode() != null) {
            if(currentNode.getData() == currentNode.getNextNode().getData()) {
                nextNode = currentNode.getNextNode().getNextNode();
                currentNode.setNextNode(nextNode);
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void reverse() {
        Node previousNode = null;
        Node currentNode = head;
        Node nextNode;
        while(currentNode != null) {
            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
    }

    // this version I tried to copy the way the stanford paper did it
//    public void reverseR(Node headNode) {
//        Node first;
//        Node rest;
//        if(headNode == null) {
//            return;
//        }
//        first = head;
//        rest = first.getNextNode();
//        if(headNode.getNextNode() == null) {
//            return;
//        }
//        reverseR(rest);
//        headNode.getNextNode().setNextNode(headNode);
//        headNode.setNextNode(null);
//        head = rest;
//    }

    // my attempt at void recursive reverse
//    public void reverseR(Node headNode) {
//        Node nextNode;
//        if(headNode == null || headNode.getNextNode() == null) {
//            return;
//        }
//        nextNode = headNode.getNextNode();
//        reverseR(nextNode);
//        headNode.getNextNode().setNextNode(headNode);
//        headNode.setNextNode(null);
//        head = nextNode;
//    }

    // working version of recursive reverse
    public Node reverseR(Node headNode) {
        Node next;
        if(headNode == null || headNode.getNextNode() == null) {
            return headNode;
        }
        next = reverseR(headNode.getNextNode());
        headNode.getNextNode().setNextNode(headNode);
        headNode.setNextNode(null);
        return next;
    }

    public void display() {
        Node currentNode = head;
        while(currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNextNode();
        }
    }

}
