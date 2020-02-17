package ninechapters.binarytreedivideconquer;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
 * the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * @author Haoming Chen
 * Created on 2020/2/18
 */
public class BinaryTreeMaximumPathSum_94 {

    class ResType{
        //最大路径值
        int maxPath;
        //包含根节点的路径值
        int singlePath;
        public ResType(int maxPath, int singlePath){
            this.maxPath = maxPath;
            this.singlePath = singlePath;
        }
    }

    private ResType helper(TreeNode root){
        if(root == null){
            return new ResType(Integer.MIN_VALUE, 0);
        }
        ResType left = helper(root.left);
        ResType right = helper(root.right);
        //获取包含该节点的路径值 -> 较大
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        //最大路径值
        singlePath = Math.max(0, singlePath);
        //获取左右子树的最大路径值
        int maxPath = Math.max(right.maxPath, left.maxPath);
        //对左右子树的最大路径值和(左子树 - 根 - 右子树)组成的路径值进行比对
        maxPath = Math.max(maxPath, right.singlePath + left.singlePath + root.val);
        return new ResType(maxPath, singlePath);
    }

    public int maxPathSum(TreeNode root) {
        return helper(root).maxPath;
    }

}
