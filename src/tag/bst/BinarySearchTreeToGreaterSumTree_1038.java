package tag.bst;

/**
 * @author Haoming Chen
 * Created on 2019/10/14
 */
public class BinarySearchTreeToGreaterSumTree_1038 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        bstToGst(root.right);
        sum = sum + root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }

}
