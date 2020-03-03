package ninechapters.dplesson1;

public class JumpGame2_leetcode45 {

    public int jump(int[] nums) {
        int max = 0;
        int steps = 0;
        int degree = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(degree >= nums.length - 1){
                return steps;
            }
            max = Math.max(max, nums[i] + i);
            //already traveled the index before degree
            if(i == degree){
                steps++;
                degree = max;
            }
        }
        return steps;
    }

}
