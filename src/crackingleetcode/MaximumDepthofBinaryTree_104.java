package crackingleetcode;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * @author 58212
 * @date 2020-01-02 22:20
 */
public class MaximumDepthofBinaryTree_104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depthL = maxDepth(root.left);
        int depthR = maxDepth(root.right);
        return depthL > depthR ? depthL + 1 : depthR + 1;
    }
}
