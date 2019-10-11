package lru;

/**
 * @author Haoming Chen
 * Created on 2019/10/9
 */
public interface LRUCache<E> {

    int get(String key);

    void set(String key, int value);

    void add(E item);

    void remove(E item);

    void moveToHead(E item);

    E popTail(E item);
}
