package tag.array;

public class SortColors_75 {
    public void sortColors(int[] nums) {
        int[] s = new int[3];
        for(int i: nums){
            if(i == 0){
                s[0]++;
            }else if(i == 1){
                s[1]++;
            }else{
                s[2]++;
            }
        }
        for(int i = 0;i<s[0];i++){
            nums[i] = 0;
        }
        for(int i = s[0];i<(s[1] + s[0]);i++){
            nums[i] = 1;
        }
        for(int i = s[0] + s[1];i<nums.length;i++){
            nums[i] = 2;

        }
    }
}
