package crackingleetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * @author 58212
 * @date 2020-01-01 11:47
 */
public class BinaryTreeLevelOrderTraversal_102 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> nodeQ = new LinkedList<>();
        int size = 1;
        nodeQ.add(root);
        List<Integer> lst = new ArrayList<>();
        while(!nodeQ.isEmpty()){
            if(size == 0){
                res.add(lst);
                lst = new ArrayList<>();
                size = nodeQ.size();
            }else{
                TreeNode td = nodeQ.poll();
                lst.add(td.val);
                if(td.left != null){
                    nodeQ.add(td.left);
                }
                if(td.right != null){
                    nodeQ.add(td.right);
                }
                size--;
            }
        }
        res.add(lst);
        return res;
    }

}
