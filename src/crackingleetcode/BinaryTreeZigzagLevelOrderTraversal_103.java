package crackingleetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 *
 * @author 58212
 * @date 2020-01-01 13:54
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int size = 1;
        Boolean zig = false;
        q.offer(root);
        List<Integer> lst = new ArrayList<>();
        while (!q.isEmpty()) {
            if (size == 0) {
                res.add(lst);
                size = q.size();
                lst = new ArrayList<>();
                zig = !zig;
            } else {
                TreeNode head = q.poll();
                if (zig) {
                    lst.add(0, head.val);
                } else {
                    lst.add(head.val);
                }
                if (head.left != null) {
                    q.add(head.left);
                }
                if (head.right != null) {
                    q.add(head.right);
                }
                size--;
            }
        }
        res.add(lst);
        return res;
    }

}
