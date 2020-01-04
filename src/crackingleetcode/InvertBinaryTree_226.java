package crackingleetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.
 * <p>
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

    //recurisive approach
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

    //breadth-first-search
    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) {
            return root;
        }
        //Queue
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode tn = q.poll();
            //swap the left and right child
            TreeNode temp = tn.left;
            tn.left = tn.right;
            tn.right = temp;

            if (tn.left != null) {
                q.offer(tn.left);
            }
            if (tn.right != null) {
                q.offer(tn.right);
            }
        }
        return root;
    }

}
