package crackingleetcode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * @author Haoming Chen
 * Created on 2020/1/5
 */
public class ValidateBinarySearchTree_98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //left tree node must smaller than root
        boolean bst = true;
        if (root.left != null) {
            int max = findMax(root.left);
            if (max >= root.val) {
                bst = false;
            }
        }
        //right tree node must bigger than root
        if (root.right != null) {
            int min = findMin(root.right);
            if (min <= root.val) {
                bst = false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right) && bst;
    }
    //the biggest node at the left child
    private int findMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    //the smallest node at the right child
    private int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

}
