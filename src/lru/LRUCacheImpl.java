package lru;

import java.util.HashMap;
import java.util.LinkedHashMap;

class LRUCacheImpl {

    HashMap<Integer, DLinkedNode> lruCacheHashMap;
    int size;
    DLinkedNode dummyHead;
    DLinkedNode dummyTail;

    public LRUCacheImpl(int capacity) {
        lruCacheHashMap = new LinkedHashMap<>(capacity + 2);
        dummyHead = new DLinkedNode();
        dummyTail = new DLinkedNode();
    }

    public int get(int key) {
        DLinkedNode ret = lruCacheHashMap.get(key);
        if (ret == null) {
            return -1;
        }
        //将ret移至头节点
        if(head == ret){
            head = size;
        }
        return ret.val;
    }

    public void put(int key, int value) {

    }

    class DLinkedNode {
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode post;
    }
}