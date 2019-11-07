package algorithm.heapandheapsort;

import java.util.Random;

/**
 * @author 58212
 * @date 2019-11-07 0:33
 */
public class MaxHeap<E extends Comparable<E>> {

    public static void main(String[] args) {
//        MaxHeap<Integer> maxHeap = new MaxHeap<>(10);
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            maxHeap.insert(random.nextInt(100));
//        }
//        for (int i = 0; i < 10; i++) {
//            System.out.print(maxHeap.extractMax() + " ");
//        }
//        System.out.println("\n" + "size equals to: " + maxHeap.getSize());
        Integer[] data = {7, 2, 9, 4, 1};
        MaxHeap<Integer> heap = new MaxHeap<>(data);
        for(int i = 0; i < 5; i ++){
            System.out.print("" + heap.extractMax());
        }

    }

    private E[] data;
    private int size;

    public MaxHeap(int capacity) {
        size = 0;
        data = (E[]) new Comparable[capacity + 1];
    }

    public MaxHeap(E[] arr) {

        data = (E[]) new Comparable[arr.length + 1];
        size = arr.length;

        for (int i = 0; i < arr.length; i++) {
            data[i + 1] = arr[i];
        }

        heapify(data);

    }

    public void insert(E ele) {
        if (size >= data.length - 1) {
            throw new IllegalArgumentException("Priority Queue is full");
        }
        data[size + 1] = ele;
        shiftUp(size + 1);
        size++;
    }

    public E extractMax() {
        E ret = data[1];
        data[1] = data[size];
        shiftDown(1);
        size--;
        return ret;
    }

    private void shiftUp(int index) {
        if (index <= 1) {
            return;
        }
        if (data[index / 2].compareTo(data[index]) > 0) {
            return;
        }
        swap(index, index / 2);
        shiftUp(index / 2);
    }

    private void shiftDown(int index) {
        //左子树存在
        while (index * 2 <= size) {
            int j = index * 2;
            //右子树存在,且右子树大于左子树
            if (j + 1 <= size && data[j].compareTo(data[j + 1]) < 0) {
                j = j + 1;
            }
            if (data[j].compareTo(data[index]) < 0) {
                break;
            }
            swap(j, index);
            index = j;
        }
    }

    public int getSize() {
        return size;
    }

    private void heapify(E[] arr) {
        //从最后一个parent节点开始做heapify操作
        for (int i = size / 2; i > 0; i--) {
            shiftDown(i);
        }
    }

    private void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
