package data_structure.SegmentTree;

public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merge<E> merger;

    public SegmentTree(E[] arr, Merge<E> merger) {
        this.merger = merger;
        this.data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        //N = 1 - N * 2 / 1 - 2 = 2N - 1
        //N > 2^k = 2N + 2N = 4N
        this.tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    //在treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            data[treeIndex] = data[l];
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = (l + r) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    // 返回区间[queryL, queryR]的值
    public E query(int queryL, int queryR) {

        if (queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //在以treeIndex为根的线段树中[l...r]的范围里,搜索区间[queryL..queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR)
            return tree[treeIndex];

        int mid = l + (r - l) / 2;
        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid + 1)
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        else if (queryR <= mid)
            return query(leftTreeIndex, l, mid, queryL, queryR);

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
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
