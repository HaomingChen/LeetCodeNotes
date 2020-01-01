package crackingleetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
 * level by level from leaf to root).
 *
 * @author 58212
 * @date 2020-01-01 13:13
 */
public class BinaryTreeLevelOrderTraversalII_107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int size = 1;
        q.offer(root);
        List<Integer> lst = new LinkedList<>();
        while (!q.isEmpty()) {
            if (size == 0) {
                res.addFirst(lst);
                lst = new LinkedList<>();
                size = q.size();
            } else {
                TreeNode curr = q.poll();
                lst.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
                size--;
            }
        }
        res.addFirst(lst);
        return res;
    }

}
