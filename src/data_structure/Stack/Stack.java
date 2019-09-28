package data_structure.Stack;

/**
 * @author 58212
 * @date 2019-09-25 0:35
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
