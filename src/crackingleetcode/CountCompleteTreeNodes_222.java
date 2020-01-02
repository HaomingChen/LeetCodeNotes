package crackingleetcode;

/**
 * Given a complete binary tree, count the number of nodes.
 *
 * @author 58212
 * @date 2020-01-02 23:55
 */
public class CountCompleteTreeNodes_222 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int size = 0;

        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int resL = 0;
            int resR = 0;
            if (root.right == null) {
                resL = countNodes(root.left);
            } else {
                resL = countNodes(root.right);
                resR = countNodes(root.left);
            }
            return resL + resR + 1;
        }
    }

}
