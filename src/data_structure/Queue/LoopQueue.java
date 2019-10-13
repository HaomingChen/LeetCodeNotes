package data_structure.Queue;

/**
 * @author 58212
 * @date 2019-09-28 22:37
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    //指向队首元素
    private int head;
    //指向队尾元素后一位
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
        data[tail % data.length] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (head == tail) {
            return null;
        }
        E ret = data[head];
        head = (head + 1) % data.length;
        size--;
        if (data.length / 4 > size) {
            resize(data.length / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        return data[head];
    }

    private void resize(int newCapacity) {
        System.out.println("resize: " + newCapacity);
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = data[(head + i) % data.length];
        }
        data = newArray;
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
