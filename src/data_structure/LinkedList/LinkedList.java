package data_structure.LinkedList;

/**
 * @author 58212
 * @date 2019-09-30 22:03
 */
public class LinkedList<E> {

    private Node dummyHead;
    private int size;

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在链表头添加新的元素e
    public void addFirst(E e) {

    }

    //在链表的index(0-based)位置添加新的元素e
    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        //没有任何元素指向它
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //prev指向新元素            新元素指向后方元素
        prev.next = new Node(e, prev.next);
        size++;
    }

    //在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(",");
        Node x = dummyHead;
        while (x.next != null) {
            stringBuilder.append(x.next.e);
            stringBuilder.append(",");
            x = x.next;
        }
        return stringBuilder.toString();
    }
}
