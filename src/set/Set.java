package set;

/**
 * @author 58212
 * @date 2019-10-13 17:08
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
