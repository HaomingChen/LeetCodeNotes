package crackingleetcode;

/**
 * @author 58212
 * @date 2019-12-13 22:19
 */
public class RemoveDuplicatedFromSortedArray_26 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        RemoveDuplicatedFromSortedArray_26 res = new RemoveDuplicatedFromSortedArray_26();
        System.out.println("results" + res.removeDuplicates(nums));
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


}
