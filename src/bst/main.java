package bst;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author 58212
 * @date 2019-10-06 23:55
 */
public class main {

    public static void main(String[] args) {
//        BST<Integer> bst = new BST<>();
//        int[] arr = {5,3,6,8,4,2};
//        for(int value : arr){
//            bst.add(value);
//        }
//        System.out.println(bst.contains(4));
//        bst.preOrder();
//        System.out.println(bst);
//        bst.levelOrder();
//        System.out.println(bst.removeMin());
//        System.out.println(bst.removeMin());
//        System.out.println("---------------------");
//        System.out.println(bst);
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        int count = 0;
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
            count++;
        }
        System.out.println(bst);
        System.out.println("----------------------------");
        System.out.println(nums);
        System.out.println("----------------------------");
        System.out.println("Count: " + count);
    }

}
