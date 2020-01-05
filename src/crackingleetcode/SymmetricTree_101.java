package crackingleetcode;

/**
 * @author Haoming Chen
 * Created on 2020/1/5
 */
public class SymmetricTree_101 {

    public boolean isSymmetric(TreeNode root) {
        return root == null || findSymmetric(root.left, root.right);
    }

    public boolean findSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return findSymmetric(left.right, right.left) && findSymmetric(left.left, right.right);
    }
}
