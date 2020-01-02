package crackingleetcode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * @author 58212
 * @date 2020-01-03 0:16
 */
public class BalancedBinaryTree_110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        boolean res = true;

        public boolean isBalanced(TreeNode root) {
            bal(root);
            return res;
        }

        public int bal(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int r = bal(root.right);
            int l = bal(root.left);
            if (Math.abs(r - l) >= 2) {
                res = false;
            }
            return r > l ? r + 1 : l + 1;
        }

    }

}
