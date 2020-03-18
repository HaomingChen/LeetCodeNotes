package ninechapters.ArrayNums;

public class Median {

    int mid;
    public int median(int[] nums) {
        int pos = 0;
        if(nums.length % 2 != 0){
            pos = 1;
        }
        int target = (nums.length + pos) / 2 - 1;
        partition(nums, target, 0, nums.length - 1);
        return mid;
    }

    private void partition(int[] nums, int target, int start, int end){
        if(start > end){
            return;
        }
        int lt = start;
        for(int i = start + 1; i <= end; i++){
            if(nums[i] < nums[start]){
                lt++;
                swap(nums, lt, i);
            }
        }
        swap(nums, start, lt);
        if(target == lt){
            mid = nums[lt];
        }else if(target < lt){
            partition(nums, target, start, lt - 1);
        }else{
            partition(nums, target, lt + 1, end);
        }
    }

    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
