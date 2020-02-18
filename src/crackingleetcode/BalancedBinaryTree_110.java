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

    //寻找左子树的最大深度和右子树最大深度的差
    public boolean isBalanced(TreeNode root) {
        return findDepth(root) != -1;
    }

    private int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = findDepth(root.left);
        if (l == -1) {
            return -1;
        }
        int r = findDepth(root.right);
        if (r == -1) {
            return -1;
        }
        if (Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }

}
