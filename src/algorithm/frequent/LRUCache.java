package algorithm.frequent;

import java.util.HashMap;

/**
 * LRU Cache
 * https://www.imooc.com/read/44/article/760
 *
 * @author 58212
 * @date 2020-01-27 19:56
 */
public class LRUCache {

    class Node {
        int val;
        int key;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node() {

        }
    }

    //Key - Node
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        count = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            node.val = value;
            insert(node);
        } else {
            Node node = new Node(key, value);
            insert(node);
        }
    }

    public void insert(Node node) {
        if (capacity > 0) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            map.put(node.key, node);
            count++;
            if (count > capacity) {
                remove(tail.prev);
            }
        }
    }

    public void remove(Node node) {
        if (count > 0) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            map.remove(node.key);
            count--;
        }
    }

}
