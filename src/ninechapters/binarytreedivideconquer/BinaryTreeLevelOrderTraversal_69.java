package ninechapters.binarytreedivideconquer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * @author Haoming Chen
 * Created on 2020/2/20
 */
public class BinaryTreeLevelOrderTraversal_69 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> lst = new LinkedList<>();
        lst.offer(root);
        int count = 1;
        List<Integer> level = new ArrayList<>();
        while (!lst.isEmpty()) {

            if (count == 0) {
                res.add(level);
                level = new ArrayList<>();
                count = lst.size();
                continue;
            }

            TreeNode node = lst.poll();
            level.add(node.val);
            if (node.left != null) {
                lst.offer(node.left);
            }
            if (node.right != null) {
                lst.offer(node.right);
            }
            count--;
        }
        res.add(level);
        return res;

    }

}
