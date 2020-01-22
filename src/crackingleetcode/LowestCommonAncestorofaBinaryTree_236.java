package crackingleetcode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * @author 58212
 * @date 2020-01-23 2:35
 */
public class LowestCommonAncestorofaBinaryTree_236 {

    //post order traversal should do
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        traverse(root, p, q);
        return res;
    }

    private boolean traverse(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        int left = traverse(root.left,p, q)? 1 : 0;
        int right = traverse(root.right,p, q)? 1 : 0;
        int mid = 0;
        if(root  == p || root == q){
            mid = 1;
        }
        if(left + mid + right >= 2){
            res = root;
        }
        return left + right + mid >= 1;
    }

}
