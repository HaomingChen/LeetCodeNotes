package map;

/**
 * @author 58212
 * @date 2019-10-13 23:42
 */
public interface Map<K, V> {

    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();

}
