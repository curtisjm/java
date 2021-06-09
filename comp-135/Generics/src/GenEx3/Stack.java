package GenEx3;

// behavior of stack: last in, first out
public interface Stack <Item> extends Iterable <Item> {

    Item pop();
    void push(Item item);
    boolean isEmpty();
    int size();
}
