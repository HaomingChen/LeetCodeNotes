package watchback;

public class SortColors_75 {

    public void sortColors(int[] nums) {
        int[] sum = new int[3];
        for (int i = 0; i < nums.length; i++) {
            sum[nums[i]]++;
        }
        int start = 0;
        for (int i = 0; i < sum.length; i++) {
            while (sum[i] != 0) {
                nums[start++] = i;
                sum[i]--;
            }
        }
    }

}
