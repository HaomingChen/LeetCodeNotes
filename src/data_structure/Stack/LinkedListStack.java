package data_structure.Stack;

/**
 * @author 58212
 * @date 2019-10-01 10:38
 */
public class LinkedListStack<E> implements Stack {

    LinkedList<E> list = new LinkedList();

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(Object o) {
        list.addFirst((E) o);
    }

    @Override
    public Object pop() {
        return list.removeFirst();
    }

    @Override
    public Object peek() {
        return list.get(0);
    }
}
