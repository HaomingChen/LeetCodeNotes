package data_structure.Queue;

/**
 * @author 58212
 * @date 2019-09-28 21:22
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();

}
