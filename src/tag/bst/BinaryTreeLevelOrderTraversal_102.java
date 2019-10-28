package tag.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Haoming Chen
 * Created on 2019/10/28
 */
public class BinaryTreeLevelOrderTraversal_102 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Stack<TreeNode> stack = new Stack<>();
            List<TreeNode> treeNodes = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                treeNodes.add(node);
                if (stack.isEmpty() && !treeNodes.isEmpty()) {
                    List<Integer> integers = new ArrayList<>();
                    for (int i = treeNodes.size() - 1; i > -1; i--) {
                        TreeNode treeNode = treeNodes.get(i);
                        if (treeNode != null) {
                            integers.add(treeNode.val);
                            stack.push(treeNode.left);
                            stack.push(treeNode.right);
                        }
                    }
                    treeNodes = new LinkedList<>();
                    if (!integers.isEmpty()) {
                        res.add(integers);
                    }
                }
            }
            return res;
        }
    }

}
