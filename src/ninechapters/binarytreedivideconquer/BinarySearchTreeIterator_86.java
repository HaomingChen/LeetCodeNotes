package ninechapters.binarytreedivideconquer;

import java.util.Stack;

/**
 * 中序遍历的迭代实现
 *
 * Design an iterator over a binary search tree with the following rules:
 * Elements are visited in ascending order (i.e. an in-order traversal)
 * next() and hasNext() queries run in O(1) time in average.
 *
 * @author Haoming Chen
 * Created on 2020/2/22
 */
public class BinarySearchTreeIterator_86 {

    TreeNode root;
    Stack<TreeNode> stack;

    /*
     * @param root: The root of binary tree.
     */
    public BinarySearchTreeIterator_86(TreeNode root) {
        this.root = root;
        stack = new Stack<>();
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        if (root != null || !stack.isEmpty()) {
            return true;
        }
        return false;
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode temp = stack.pop();
        root = temp.right;
        return temp;
    }

}
