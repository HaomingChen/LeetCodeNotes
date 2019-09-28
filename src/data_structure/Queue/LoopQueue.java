package data_structure.Queue;

/**
 * @author 58212
 * @date 2019-09-28 22:37
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int head;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        head = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == tail ? true : false;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == head) {
            resize(data.length * 2 - 1);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (getSize() == 0) {
            throw new IllegalArgumentException("Can not dequeue, since this queue is empty");
        }
//        System.out.println("size：" + size);
//        System.out.println("data.length - 1：" + (data.length - 1)/4);
        if (size < ((data.length - 1) / 4) && data.length / 2 > 0) {
            resize((data.length) / 2 + 1);
        }
        E ret = data[head];
        data[head] = null;
        head++;
        size--;
        return ret;
    }

    @Override
    public E getFront() {
        return data[head];
    }

    private void resize(int newCapacity) {
        System.out.println("resize starts");
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(head + i) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder queue = new StringBuilder();
        queue.append(String.format("Queue size is %d, and length is %d ", getSize(), data.length));
        for (int i = 0; i < size; i++) {
            queue.append(data[(head + i) % data.length]);
            queue.append(",");
        }
        return queue.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
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
