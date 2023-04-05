package classLearning.acwing.baseClass.dp;

import java.util.Scanner;

public class N11 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] nums = new int[n + 1];
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = in.nextInt();
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int left = 1; left + len - 1 <= n; left++) {
                int right = left + len - 1;
                dp[left][right] = Integer.MAX_VALUE;
                for (int k = left + 1; k <= right; k++) {
                    dp[left][right] = Math.min(dp[left][right],dp[left][k - 1] + dp[k][right] + preSum[right] - preSum[left - 1]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
