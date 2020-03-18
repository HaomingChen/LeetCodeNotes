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

    //将index位置的值更新为e
    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            return;
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    //在以treeIndex为根的线段树中更新index的值为e
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        if (index >= mid + 1) {
            set(rightChild, mid + 1, r, index, e);
        } else {
            set(leftChild, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);
    }

    //在treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int mid = (l + r) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        buildSegmentTree(leftChild, l, mid);
        buildSegmentTree(rightChild, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);
    }

    // 返回区间[queryL, queryR]的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryR < 0 || queryL > data.length - 1 || queryR > data.length - 1) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //在以treeIndex为根的线段树中[l...r]的范围里,搜索区间[queryL..queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (queryL == l && queryR == r) {
            return tree[treeIndex];
        }
        int mid = (l + r) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        if (mid >= queryR) {
            return query(leftChild, l, mid, queryL, queryR);
        } else if (mid + 1 <= queryL) {
            return query(rightChild, mid + 1, r, queryL, queryR);
        }
        E left = query(leftChild, l, mid, queryL, mid);
        E right = query(rightChild, mid + 1, r, mid + 1, queryR);
        return merger.merge(left, right);
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

    @Override
    public String toString() {
        if (tree == null || tree.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tree.length - 1; i++) {
            sb.append(tree[i] + ", ");
        }
        sb.append(tree[tree.length - 1] + "]");
        return sb.toString();
    }
}
