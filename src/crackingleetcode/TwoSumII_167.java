package crackingleetcode;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number. The function twoSum should return indices of the two numbers such that they add up to the
 * target, where index1 must be less than index2.
 *
 * @author Haoming Chen
 * Created on 2019/12/14
 */
public class TwoSumII_167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) {
            return numbers;
        }
        int[] res = new int[2];
        int head = 0;
        int tail = numbers.length - 1;
        while (head < tail) {
            if (numbers[head] + numbers[tail] == target) {
                res[0] = ++head;
                res[1] = ++tail;
                return res;
            } else if (numbers[head] + numbers[tail] > target) {
                tail--;
            } else {
                head++;
            }
        }
        return numbers;
    }

    public int[] twoSumApproach2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int res = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (res != -1) {
                return new int[]{++i, ++res};
            }
        }
        return numbers;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start - (start - end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
