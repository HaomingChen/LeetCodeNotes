package tag.math;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Haoming Chen
 * Created on 2019/10/11
 */
public class ShuffleAnArray_384 {

    int[] nums;
    int size;

    public ShuffleAnArray_384(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {

        int[] shuffled = Arrays.copyOf(nums, size);
        for (int i = 0; i < size; i++) {
            int pos = randomInt(i, size);
            int temp = shuffled[i];
            shuffled[i] = shuffled[pos];
            shuffled[pos] = temp;
        }
        return shuffled;

    }

    private static int randomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 8, 4, 9};
        ShuffleAnArray_384 obj = new ShuffleAnArray_384(nums);
        System.out.println("--------------");
        int[] param_2 = obj.shuffle();
        for (int s : param_2) {
            System.out.println(s + " ");
        }
        System.out.println("--------------");
        int[] param_1 = obj.reset();
        for (int s : param_1) {
            System.out.println(s + " ");
        }
    }

}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
