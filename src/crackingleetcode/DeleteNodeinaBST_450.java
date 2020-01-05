package crackingleetcode;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 * @author Haoming Chen
 * Created on 2020/1/5
 */
public class DeleteNodeinaBST_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //Hibbard Deletion
            TreeNode temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            root.val = temp.val;
            root.right = deleteNode(root.right, root.val);
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
