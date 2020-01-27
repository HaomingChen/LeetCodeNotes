package algorithm.frequent;

import java.util.Arrays;

/**
 * 重建二叉树
 *
 * @author 58212
 * @date 2020-01-27 23:48
 */
public class ReConstructBinaryTree {
   public TreeNode reConstructBinaryTree(int[] pre, int[] in){
       if(pre.length == 0 || in.length == 0){
           return null;
       }
       TreeNode root = new TreeNode(pre[0]);
       for(int i = 0; i < in.length; i++){
           if(pre[0] == in[i]){
               root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1),
                       Arrays.copyOfRange(in, 0, i));
               root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                       Arrays.copyOfRange(in, i + 1, in.length));
               break;
           }
       }
       return root;
   }
}
