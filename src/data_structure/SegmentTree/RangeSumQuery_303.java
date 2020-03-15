package data_structure.SegmentTree;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * @author Haoming Chen
 * Created on 2020/3/15
 */
public class RangeSumQuery_303 {
    //dp solution
    int[] dp;

    public RangeSumQuery_303(int[] nums) {
        dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = nums[i - 1] + dp[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
//    private interface Merge<E> {
//        E merge(E a, E b);
//    }
//
//    private class SegmentTree<E> {
//
//        private E[] tree;
//        private E[] data;
//        private Merge<E> merger;
//
//        public SegmentTree(E[] arr, Merge<E> merger) {
//            this.merger = merger;
//            this.data = (E[]) new Object[arr.length];
//            for (int i = 0; i < arr.length; i++) {
//                data[i] = arr[i];
//            }
//            this.tree = (E[]) new Object[4 * arr.length];
//            buildSegmentTree(0, 0, arr.length - 1);
//        }
//
//        private void buildSegmentTree(int treeIndex, int l, int r) {
//            if (l == r) {
//                tree[treeIndex] = data[l];
//                return;
//            }
//            int mid = (l + r) / 2;
//            int leftChild = leftChild(treeIndex);
//            int rightChild = rightChild(treeIndex);
//            buildSegmentTree(leftChild, l, mid);
//            buildSegmentTree(rightChild, mid + 1, r);
//            tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);
//        }
//
//        public E query(int queryL, int queryR) {
//            if (queryL < 0 || queryR < 0 || queryL > data.length - 1 || queryR > data.length - 1) {
//                throw new IllegalArgumentException("Invalid input parameters");
//            }
//            return query(0, 0, data.length - 1, queryL, queryR);
//        }
//
//        private E query(int treeIndex, int l, int r, int queryL, int queryR) {
//            if (queryL == l && queryR == r) {
//                return tree[treeIndex];
//            }
//            int mid = (l + r) / 2;
//            int leftChild = leftChild(treeIndex);
//            int rightChild = rightChild(treeIndex);
//            if (mid >= queryR) {
//                return query(leftChild, l, mid, queryL, queryR);
//            } else if (mid + 1 <= queryL) {
//                return query(rightChild, mid + 1, r, queryL, queryR);
//            }
//            E left = query(leftChild, l, mid, queryL, mid);
//            E right = query(rightChild, mid + 1, r, mid + 1, queryR);
//            return merger.merge(left, right);
//        }
//
//        public int getSize() {
//            return data.length;
//        }
//
//        public E get(int index) {
//            return data[index];
//        }
//
//        public int leftChild(int index) {
//            return index * 2 + 1;
//        }
//
//        public int rightChild(int index) {
//            return index * 2 + 2;
//        }
//    }
//
//    private SegmentTree<Integer> segmentTree;
//
//    public RangeSumQuery_303(int[] nums) {
//        if (nums.length > 0) {
//            Integer[] data = new Integer[nums.length];
//            for (int i = 0; i < nums.length; i++) {
//                data[i] = nums[i];
//            }
//            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        if (segmentTree == null) {
//            throw new IllegalArgumentException("Segment Tree is null");
//        }
//        return segmentTree.query(i, j);
//    }
}
