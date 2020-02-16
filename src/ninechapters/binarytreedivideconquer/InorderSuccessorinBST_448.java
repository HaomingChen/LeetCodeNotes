package ninechapters.binarytreedivideconquer;

/**
 * Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.
 * If the given node has no in-order successor in the tree, return null.
 *
 * @author Haoming Chen
 * Created on 2020/2/17
 */
public class InorderSuccessorinBST_448 {

    TreeNode res;
    TreeNode temp;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        traversal(root, p);
        return temp;
    }

    private void traversal(TreeNode root, TreeNode p){
        if(root == null){
            return;
        }
        traversal(root.left, p);
        if(res == p){
            temp = root;
        }
        res = root;
        traversal(root.right, p);
    }

}
