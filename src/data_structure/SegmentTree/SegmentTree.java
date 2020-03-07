package data_structure.SegmentTree;

public class SegmentTree<E> {

    private E[] tree;
    private E[] data;

    public SegmentTree(E[] arr) {
        this.data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        //N = 1 - N * 2 / 1 - 2 = 2N - 1
        //N > 2^k = 2N + 2N = 4N
        this.tree = (E[]) new Object[4 * arr.length];
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        return data[index];
    }

    //返回完全二叉数的数组表示中,一个索引所表示的元素的左孩子的节点的索引
    public int leftChild(int index) {
        //以0为根节点
        return index * 2 + 1;
    }

    //返回完全二叉数的数组表示中,一个索引所表示的元素的左孩子的节点的索引
    public int rightChild(int index) {
        return index * 2 + 2;
    }

}
