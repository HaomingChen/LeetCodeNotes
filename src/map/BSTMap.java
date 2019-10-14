package map;

import java.util.ArrayList;

/**
 * 二分搜索树实现映射
 *
 * @author 58212
 * @date 2019-10-14 22:50
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    Node root;
    int size;

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    //向二分搜索树中添加元素
    public Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (node.key.compareTo(key) > 0) {
            node.left = add(node.left, key, value);
        } else if (node.key.compareTo(key) < 0) {
            node.right = add(node.right, key, value);
        } else if (node.key.compareTo(key) == 0) {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node removedNode = getNode(key);
        if (removedNode != null) {
            root = removeNode(root, key);
            return removedNode.value;
        }
        return null;
    }


    //返回删除节点后新的二分搜索树的根
    private Node removeNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        //e小于node -> 向左递归
        if (node.key.compareTo(key) > 0) {
            node.left = removeNode(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            //e 大于node元素 -> 向右递归
            node.right = removeNode(node.right, key);
        } else {
            if (node.right == null && node.left != null) {
                size--;
                Node newRoot = node.left;
                node.left = node.right = null;
                return newRoot;
            } else if (node.left == null && node.right != null) {
                size--;
                Node newRoot = node.right;
                node.left = node.right = null;
                return newRoot;
            } else if (node.left == null && node.right == null) {
                size--;
                node.left = node.right = null;
                return null;
            } else {
                size--;
                Node successor = minimum(node.right);
                successor.left = node.left;
                successor.right = removeMin(node.right);
                node.left = node.right = null;
                return successor;
            }
        }
        return node;
    }


    public Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //删除以node为根的二分搜索树中的最小节点
    //返回二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left != null) {
            node.left = removeMin(node.left);
            return node;
        } else {
            size--;
            return node.right == null ? null : node.right;
        }
    }

    private Node getNode(K key) {
        return getNode(root, key);
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) > 0) {
            return getNode(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            return getNode(node.right, key);
        }
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(key).value;
    }

    @Override
    public void set(K key, V newValue) {
        if (!contains(key)) {
            throw new IllegalArgumentException("target key not found");
        }
        getNode(key).value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("E:\\workspace2\\LeetCodeNotes\\src\\map\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
