package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-17 11:40
 */
public class N413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length <3){
            return 0;
        }
        int total = 0;
        int numsLen = nums.length;
        boolean[][] dp = new boolean[numsLen][numsLen];
        for (int i = 0; i < numsLen; i++) {
            dp[i][i] = true;
        }
        for (int len = 3; len <= numsLen; len++) {
            for (int left = 0; left < numsLen ; left++) {
                int right = left+len -1;
                if (right >= numsLen){
                    break;
                }
                if (nums[right]-nums[right-1] !=nums[right-1]-nums[right-2] ){
                    dp[left][right] = false;
                }else {
                    if (right - left <3){
                        dp[left][right] = true;
                    }else {
                        dp[left][right] = dp[left][right-1];
                    }

                }
                if (dp[left][right] && right - left>=2){
                    total++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        N413 n413 = new N413();
        int[] nums = {1,2,3,4};
        System.out.println(n413.numberOfArithmeticSlices(nums));
    }
}
