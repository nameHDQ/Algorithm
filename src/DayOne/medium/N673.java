package DayOne.medium;

/**
 * @author hdq
 * @create 2021-09-20 9:36
 */
public class N673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length,maxLen = 0 ,ans = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] >nums[j]){
                    if (dp[j] +1 > dp[i]){
                        //更新最大长度
                        dp[i] = dp[j] +1;
                        //更新最大长度的子序列个数
                        cnt[i] = cnt[j];
                    }else if (dp[j] +1 == dp[i]){
                        //长度相同，加长新的一个中转节点的子序列
                        cnt[i] +=cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen){
                maxLen = dp[i];
                ans = cnt[i];
            }else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }


    public int findNumberOfLIS1(int[] nums) {
        int n = nums.length,maxLen = 0 ,ans = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    // 更长的子序列断出现，更新长度和个数
                    if (dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }else {
                        // 长度相同的情况下 更新个数
                        if (dp[j] + 1 == dp[i]){
                            cnt[i] += cnt[j];
                        }
                    }
                }
            }
            if (dp[i] > maxLen){
                maxLen = dp[i];
                ans = cnt[i];
            }
            else {
                if (dp[i] == maxLen){
                    ans += cnt[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        N673 n673 = new N673();
        int[] nums = {1,3,5,4,7};
        System.out.println(n673.findNumberOfLIS(nums));
    }
}
