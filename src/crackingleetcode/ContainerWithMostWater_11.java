package crackingleetcode;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 *
 * @author 58212
 * @date 2019-12-19 23:46
 */
public class ContainerWithMostWater_11 {

    //To solve this question, the most important thing is to understand when the value
    //that pointed by the left pointer is less than the value of right pointer, you can not move the right pointer
    //to the left to get a larger "container".
    class Solution {
        public int maxArea(int[] height) {

            int max = 0;
            int lt = 0;
            int rt = height.length - 1;
            //[lt, rt]
            while(lt < rt){
                if(height[rt] > height[lt]){
                    max = height[lt] * (rt - lt) > max? height[lt] * (rt - lt) : max;
                    lt ++;
                }else{
                    max = height[rt] * (rt - lt) > max? height[rt] * (rt - lt) : max;
                    rt --;
                }
            }
            return max;

        }
    }

}
