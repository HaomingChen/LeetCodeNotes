package crackingleetcode;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * @author Haoming Chen
 * Created on 2020/3/4
 */
public class KthSmallestElementinaBST_230 {

    //inorder traversal
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.isEmpty()) {
            //dfs
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            TreeNode temp = stk.pop();
            if (--k == 0) {
                return temp.val;
            }
            root = temp.right;
        }
        return -1;
    }

}
