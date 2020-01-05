package crackingleetcode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Note: A leaf is a node with no children.
 *
 * @author Haoming Chen
 * Created on 2020/1/4
 */
public class SumRootToLeafNumbers_129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSum(root, 0);
    }

    //the sum of nodes value from bottum to top
    private int getSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val + sum * 10;
        }
        return getSum(root.left, root.val + sum * 10) + getSum(root.right, root.val + sum * 10);
    }

}
