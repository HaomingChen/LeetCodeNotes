package algorithm.frequent;

/**
 * 回溯法 变态跳台阶
 * @author 58212
 * @date 2020-01-29 1:52
 */
public class 变态跳台阶 {

    int count = 0;

    public int JumpFloorII(int target) {
        if (target <= 1) {
            return target;
        }
        jumpFloor(target);
        return count;
    }

    private void jumpFloor(int target) {
        count++;
        for (int i = 1; i <= target; i++) {
            jumpFloor(target - i);
        }
    }

}
