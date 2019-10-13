package map;

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
        add(0, e);
    }

    //在链表的index(0-based)位置添加新的元素e
//    public void add(int index, E e) {
//        if (index > size || index < 0) {
//            throw new IllegalArgumentException("Add failed. Illegal index.");
//        }
//        //没有任何元素指向它
//        Node prev = dummyHead;
//        for (int i = 0; i < index; i++) {
//            prev = prev.next;
//        }
//        //prev指向新元素            新元素指向后方元素
//        prev.next = new Node(e, prev.next);
//        size++;
//    }

    //在链表的index(0-based)位置添加新的元素e(递归实现)
    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Please enter a valid index number");
        }
        add(dummyHead, index, e);
    }

    public void add(Node node, Integer index, E e) {
        if (index == 0) {
            node.next = new Node(e, node.next);
            size++;
            return;
        } else if (index > 0) {
            add(node.next, --index, e);
        }
    }

    //在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    //获得链表的第index个位置的元素
    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("invalid index found");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    //获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    //从链表中删除index(0-based)位置的元素 返回删除的元素
    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("index is too big or too small");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //必须改变cur的指针而不是cur所以cur = cur.next无效
        Node cur = prev.next;
        prev.next = cur.next;
        cur.next = null;
        size--;
        return cur.e;
    }

    //从链表中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    //从链表中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size);
    }

    //更新链表的第index位置的元素
    public void update(int index, E e) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("invalid index, please enter a proper one");
        }
        Node cur = dummyHead.next;
        int count = 0;
        while (cur != null) {
            if (count == index) {
                cur.e = e;
            }
            cur = cur.next;
            count++;
        }
    }

    //查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //从链表中删除元素e
    public void removeElement(E e) {
        removeElement(dummyHead, e);
    }

    private void removeElement(Node node, E e) {
        if (node.next == null) {
            return;
        }
        if (node.next.e == e) {
            node.next = node.next.next;
        } else {
            removeElement(node.next, e);
        }
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
