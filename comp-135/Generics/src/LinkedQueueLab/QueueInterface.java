package LinkedQueueLab;

public interface QueueInterface <Item> extends Iterable <Item> {

    Item pop();
    void push(Item item);
    boolean isEmpty();
    int size();
}
