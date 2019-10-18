package maxheap;

import data_structure.Array.Array;

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
        E ret = data.getFirst();
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

}
