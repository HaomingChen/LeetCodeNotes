package crackingleetcode;

/**
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate
 * between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence
 * with fewer than two elements is trivially a wiggle sequence.
 *
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and
 * negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two
 * differences are positive and the second because its last difference is zero.
 *
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence
 * is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the
 * remaining elements in their original order.
 *
 * @author 58212
 * @date 2020-01-20 3:10
 */
public class WiggleSubSequence_376 {

    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        int[] low = new int[nums.length];
        int[] hi = new int[nums.length];
        low[0] = 1;
        hi[0] = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                hi[i] = low[i - 1] + 1;
                low[i] = low[i - 1];
            }else if(nums[i] < nums[i - 1]){
                low[i] = hi[i - 1] + 1;
                hi[i] = hi[i - 1];
            }else{
                low[i] = low[i - 1];
                hi[i] = hi[i - 1];
            }
        }
        return Math.max(low[low.length -1], hi[hi.length - 1]);
    }

}
