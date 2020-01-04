package crackingleetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 *
 * @author 58212
 * @date 2020-01-02 22:40
 */
public class MinimumDepthOfBinaryTree_111 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //BFS
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int size = 1;
        int level = 1;
        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        nodeQ.offer(root);
        while(!nodeQ.isEmpty()){
            if(size != 0){
                TreeNode node = nodeQ.poll();
                if(node.left == null && node.right == null){
                    return level;
                }else{
                    if(node.left != null){
                        nodeQ.offer(node.left);
                    }
                    if(node.right != null){
                        nodeQ.offer(node.right);
                    }
                }
                size--;
            }else{
                level++;
                size = nodeQ.size();
            }
        }
        throw new IllegalArgumentException("Illegal Binary Tree");
    }
    //DFS
//    public int minDepth(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        if(root.right == null){
//            return 1 + minDepth(root.left);
//        }
//        if(root.left == null){
//            return 1 + minDepth(root.right);
//        }
//        return 1 + Math.min(minDepth(root.right), minDepth(root.left));
//    }
}
