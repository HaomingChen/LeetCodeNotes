package map;

import java.util.ArrayList;

/**
 * @author 58212
 * @date 2019-10-13 23:44
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    private class Node {
        public K k;
        public V v;
        public Node next;

        public Node(K k, V v, Node next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public Node(K k, V v) {
            this(k, v, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return "key:" + k.toString() + "," + "value:" + v.toString();
        }
    }

    private Node hasNode(K k) {
        Node traceNode = dummyHead;
        while (traceNode.next != null) {
            if (traceNode.next.k.equals(k)) {
                return traceNode.next;
            }
            traceNode = traceNode.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = hasNode(key);
        if (node != null) {
            node.v = value;
        }
        dummyHead.next = new Node(key, value, dummyHead.next);
        size++;
        return;
    }

    @Override
    public V remove(K key) {

        Node traceNode = dummyHead;
        while (traceNode.next != null) {
            if (traceNode.next.k.equals(key)) {
                Node ret = traceNode.next;
                traceNode.next = ret.next;
                ret.next = null;
                size--;
                return ret.v;
            }
            traceNode = traceNode.next;
        }
        return null;

    }

    @Override
    public boolean contains(K key) {
        return hasNode(key) != null;
    }

    @Override
    public V get(K key) {
        return hasNode(key).v;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = hasNode(key);
        if (node != null) {
            node.v = newValue;
        } else {
            throw new IllegalArgumentException("Invalid key found");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("E:\\workspace2\\LeetCodeNotes\\src\\map\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
