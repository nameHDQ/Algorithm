package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-15 14:51
 */
public class N55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i<=rightMost){
                rightMost = Math.max(rightMost, i+nums[i]);
                if (rightMost >n-1){
                    return true;
                }
            }
        }
        return false;
    }
}
