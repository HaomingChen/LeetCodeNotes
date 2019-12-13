package crackingleetcode;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
 * extra memory.The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * @author 58212
 * @date 2019-12-13 22:18
 */
public class RemoveElement_27 {

    public int removeElement(int[] nums, int val) {

        if(nums.length == 0){
            return 0;
        }
        int j = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

}
