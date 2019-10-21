package maxheap;

import data_structure.Array.Array;

import java.util.Random;

/**
 * 最大堆
 *
 * @author 58212
 * @date 2019-10-16 23:19
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    //返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    //返回一个布尔值,表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中,一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index < 0 || index >= data.getSize()) {
            throw new IllegalArgumentException("parent: invalid index input");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        if (index < 0 || index >= data.getSize()) {
            throw new IllegalArgumentException("leftChild: invalid index input");
        }
        return 2 * index + 1;
    }

    //返回完全二叉树的数组表示中一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        if (index < 0 || index >= data.getSize()) {
            throw new IllegalArgumentException("rightChild: invalid index input");
        }
        return 2 * index + 2;
    }

    //向堆中添加元素
    public void add(E e) {
        //添加元素至堆尾
        data.addLast(e);
        //元素上浮
        siftUp(size() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    //看堆中的最大元素
    public E findMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("This heap is Empty and nothing can be retrieved");
        }
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, size() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (k * 2 + 1 < data.getSize()) {
            int change = k * 2 + 1;
            if (change + 1 < data.getSize()) {
                if (data.get(change).compareTo(data.get(change + 1)) < 0) {
                    change = change + 1;
                }
            }
            if (data.get(change).compareTo(data.get(k)) < 0) {
                break;
            }
            data.swap(k, change);
            k = change;
        }
    }

    // 取出堆中最大元素，并且替换成元素e
    public E replace(E e) {
        E ret = data.getFirst();
        data.changeIndex(0, e);
        siftDown(0);
        return ret;
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        //将除叶子节点以外的节点做sift down操作
        //初始节点的值等于最后一个叶子节点的父亲节点
        for (int i = parent(data.getSize() - 1); i > -1; i--) {
            siftDown(i);
        }
    }

    public static void main(String[] args) {

        Integer[] heapify = new Integer[10000];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            heapify[i] = random.nextInt(Integer.MAX_VALUE);
        }
        MaxHeap heapA = testHeap(heapify, false);
        MaxHeap heapB = testHeap(heapify, true);
        System.out.println(heapA.size());
        System.out.println(heapB.size());
        testHeap(heapA);
        testHeap(heapB);

    }

    //测试Heap的正确性
    private static void testHeap(MaxHeap<Integer> maxHeap) {
        int count = 0;
        int[] arr = new int[maxHeap.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < arr.length; i++) {
            System.out.print("-" + count++ + "-");
            System.out.print(arr[i] + " ");
            if (arr[i] > arr[i - 1]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed");
    }

    //测试heapify -> O(n) 和 heapify -> O(nlogn)的时间复杂度
    public static MaxHeap testHeap(Integer[] testData, boolean isHeapify) {

        long startTime = System.nanoTime();
        MaxHeap maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap(testData);
        } else {
            maxHeap = new MaxHeap();
            for (int i = 0; i < testData.length; i++) {
                maxHeap.add(testData[i]);
            }
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        return maxHeap;

    }

}
