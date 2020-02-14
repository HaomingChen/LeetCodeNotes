package ninechapters.binarytreedivideconquer;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * @author Haoming Chen
 * Created on 2020/2/15
 */
public class MaximumDepthofBinaryTree_97 {

    /**
     * Divide and Conquer
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;

    }

}
