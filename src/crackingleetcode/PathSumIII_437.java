package crackingleetcode;

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent
 * nodes to child nodes). The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * @author 58212
 * @date 2020-01-05 1:36
 */
public class PathSumIII_437 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //first we need to travel around this tree
        //get the number of paths started at root
        int res = 0;
        res += findPaths(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    private int findPaths(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res++;
        }
        res += findPaths(root.left, sum - root.val);
        res += findPaths(root.right, sum - root.val);
        return res;
    }
}
