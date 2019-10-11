package bst;

/**
 * @author 58212
 * @date 2019-10-06 23:55
 */
public class main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] arr = {28,30,16,13,22,29,42};
        for(int value : arr){
            bst.add(value);
        }
        System.out.println(bst.contains(4));
        bst.preOrder();
        System.out.println(bst);
        bst.levelOrder();
    }

}
