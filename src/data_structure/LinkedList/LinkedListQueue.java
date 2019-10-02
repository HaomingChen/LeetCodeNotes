package data_structure.LinkedList;

import data_structure.Queue.Queue;

/**
 * @author 58212
 * @date 2019-10-02 21:22
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node<E> {
        public E e;
        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(E e) {
        if (size == 0) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (size == 0) {
            throw new IllegalArgumentException("This is an empty queue");
        }
        Node ret = head;
        if (size == 1) {
            tail = null;
        }
        head = head.next;
        size--;
        return (E) ret.e;
    }

    @Override
    public E getFront() {
        return (E) tail.e;
    }

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node ret = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(ret.e);
            stringBuilder.append(",");
            ret = ret.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i % 3 == 0) {
                queue.dequeue();
            }
            System.out.println(queue);
        }
        System.out.println(queue);
    }


}
