package LinkedQueueLab;

import java.util.Iterator;

public class LinkedQueue <Item> implements QueueInterface <Item> {

    private class Node {
        Item data;
        Node next;
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }

    public Item pop() {
        Item item = first.data;
        first = first.next;
        if(isEmpty()) {
            last = null;
        }
        size--;
        return item;
    }

    public void push(Item item) {
       Node oldLast = last;
       last = new Node();
       last.data = item;
       last.next = null;
       if(isEmpty()) {
           first = last;
       } else {
           oldLast.next = last;
           last = oldLast;
       }
       size++;
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    public class LinkedIterator implements Iterator<Item> {
        private int i = size;
        private Node head = last;

        public boolean hasNext() {
            return head != null;
        }

        public Item next() {
            Item item = head.data;
            head = head.next;
            i--;
            return item;
        }
    }
}
