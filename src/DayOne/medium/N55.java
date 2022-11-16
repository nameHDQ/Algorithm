package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-15 14:51
 */
public class N55 {
    public boolean canJump(int[] nums) {
//        int n = nums.length;
//        int rightMost = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            if (i<=rightMost){
//                rightMost = Math.max(rightMost, i+nums[i]);
//                if (rightMost >n-1){
//                    return true;
//                }
//            }
//        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < i){
                return false;
            }else if (dp[i - 1] == i && nums[i] == 0){
                return false;
            }
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
        }
        if (dp[nums.length - 1] > nums.length - 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        new N55().canJump(nums);
    }
}
