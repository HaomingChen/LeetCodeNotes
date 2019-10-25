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

    //中序遍历, 深度优先
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        //首先到达右子树的最深部分
        bstToGst(root.right);
        sum = sum + root.val;
        root.val = sum;
        bstToGst(root.left);
        //返回根节点
        return root;
    }

}
