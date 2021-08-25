package watchback;

public class SortColors_75 {

    public void sortColors(int[] nums) {
        int[] sum = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum[0]++;
            }
            if (nums[i] == 1) {
                sum[1]++;
            }
            if (nums[i] == 2) {
                sum[2]++;
            }
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
