package data_structure.Trie;

import java.util.TreeMap;

public class Trie {

    private class Node {

        boolean isWord;
        TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }

    }

    int size;
    Node root;

    public Trie() {
        root = new Node();
        size = 0;
    }

    //向Trie中添加一个新的单词word
    public void add(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.next.containsKey(word)) {
                node.next.put(word.charAt(i), new Node());
            }
            node = node.next.get(word.charAt(i));
        }
        if (!node.isWord) {
            node.isWord = true;
            size++;
        }
    }

    //获得Trie中存储的单词数量
    public int getSize() {
        return this.size;
    }

    //查询单词word是否在Trie中
    public boolean contains(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

}
