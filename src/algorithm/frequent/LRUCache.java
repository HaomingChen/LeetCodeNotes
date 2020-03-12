package algorithm.frequent;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache
 * https://www.imooc.com/read/44/article/760
 *
 * @author 58212
 * @date 2020-01-27 19:56
 */
public class LRUCache {

    class Node {

        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node() {

        }
    }

    Map<Integer, Node> dic;
    int capacity;
    int size;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        dic = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (!dic.containsKey(key)) {
            return -1;
        }
        Node node = dic.get(key);
        remove(node);
        insert(node);
        return dic.get(key).val;
    }

    public void put(int key, int value) {
        if (!dic.containsKey(key)) {
            insert(new Node(key, value));
            return;
        }
        Node node = dic.get(key);
        remove(node);
        node.val = value;
        insert(node);
    }

    private void insert(Node node) {
        if (capacity < 0) {
            return;
        }
        dic.put(node.key, node);
        node.prev = head;
        node.next = head.next;
        node.prev.next = node;
        node.next.prev = node;
        size++;
        if (size > capacity) {
            remove(tail.prev);
        }
    }

    private void remove(Node node) {
        if (size <= 0) {
            return;
        }
        dic.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

}
