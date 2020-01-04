package crackingleetcode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * @author Haoming Chen
 * Created on 2020/1/4
 */
public class PathSum_112 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        boolean resL = hasPathSum(root.left, sum - root.val);
        boolean resR = hasPathSum(root.right, sum - root.val);
        if (resL || resR) {
            return true;
        }
        return false;
    }

}
