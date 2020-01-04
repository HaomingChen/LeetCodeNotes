package crackingleetcode;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * @author Haoming Chen
 * Created on 2020/1/4
 */
public class SumOfLeftLeaves_404 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumL;
        int sumR;
        //check if the left child is a leaf
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sumL = root.left.val;
                sumR = sumOfLeftLeaves(root.right);
                return sumL + sumR;
            }
        }
        //if left child is not a leaf
        sumL = sumOfLeftLeaves(root.left);
        sumR = sumOfLeftLeaves(root.right);
        return sumL + sumR;
    }
}
