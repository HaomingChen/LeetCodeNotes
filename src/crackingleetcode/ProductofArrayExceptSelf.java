package crackingleetcode;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0){
            return nums;
        }
        int[] fwd = new int[nums.length];
        int[] bkg = new int[nums.length];
        fwd[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            fwd[i] = fwd[i - 1] * nums[i - 1];
        }
        bkg[bkg.length - 1] = 1;
        for (int i = bkg.length - 2; i >= 0; i--) {
            bkg[i] = bkg[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = fwd[i] * bkg[i];
        }
        return nums;
    }
}
