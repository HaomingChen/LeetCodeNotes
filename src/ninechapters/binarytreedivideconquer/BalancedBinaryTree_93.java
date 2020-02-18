package ninechapters.binarytreedivideconquer;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 *
 * @author Haoming Chen
 * Created on 2020/2/19
 */
public class BalancedBinaryTree_93 {

    boolean res;

    public boolean isBalanced(TreeNode root) {
        res = true;
        if (root == null) {
            return res;
        }
        traverse(root);
        return res;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        return Math.max(left, right) + 1;
    }

}
