package GenEx3;

import java.util.Iterator;

public class LinkedStack <Item> implements Stack <Item> {

    private class Node {
        Item data;
        Node next;
    }

    // members of lined stack
    private Node head;
    private int size;

    public LinkedStack() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        // if size is 0, return true
        return size==0;
    }

    public int size() {
        return size;
    }

    // pop out last item created, give me data from that item
    public Item pop() {
        Item item = head.data;
        head = head.next;
        size--;
        return item;
    }

    public void push(Item item) {
        Node oldHead = head;
        // makes new bok in linked stack
        head = new Node();
        head.data = item;
        // new compartment is linked to the rest of the train
        head.next = oldHead;
        size++;
    }

    public Iterator <Item> iterator() {
        return new LinkedIterator();
    }

    public class LinkedIterator implements Iterator<Item> {
        private int i = size;
        private Node first = head;

        public boolean hasNext() {
            return (i>0);
        }

        public Item next() {
            Item item = first.data;
            first = first.next;
            i--;
            return item;
        }

        public void remove() {
            // wont do this, optional operation
        }
    }
}
