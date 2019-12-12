package crackingleetcode;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the
 * non-zero elements.
 *
 * @author 58212
 * @date 2019-12-13 2:05
 */
public class MoveZeros_283 {

    static MoveZeros_283 moveZeros_283 = new MoveZeros_283();

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeros_283.moveZeroes(arr);
        System.out.println(arr);
    }

    public void moveZeroes(int[] nums) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nums[pointer] != 0) {
                    swap(nums, pointer, i);
                }
                pointer++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
//    public void moveZeroes(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return;
//        }
//        int pointer = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] != 0){
//                nums[pointer] = nums[i];
//                pointer ++;
//            }
//        }
//        for(int i = nums.length - 1 ; i >= pointer; i--){
//            nums[i] = 0;
//        }
//    }
}
