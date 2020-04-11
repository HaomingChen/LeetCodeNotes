package crackingleetcode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is
 * the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 */
public class DiameterofBinaryTree_543 {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return -1;
        }
        ans = 1;
        traverse(root);
        return ans - 1;
    }

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = traverse(root.left);
        int R = traverse(root.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }

}
