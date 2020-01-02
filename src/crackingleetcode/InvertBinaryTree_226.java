package crackingleetcode;

/**
 * Invert a binary tree.
 *
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a
 * whiteboard so f*** off.
 *
 * @author 58212
 * @date 2020-01-02 23:19
 */
public class InvertBinaryTree_226 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode nodeL = root.left;
        root.left = root.right;
        root.right = nodeL;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
