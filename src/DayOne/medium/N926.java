package DayOne.medium;

/**
 * @author hdq
 * @create 2022-06-11 10:15
 */
public class N926 {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
        char[] chars = s.toCharArray();
        dp[0][0] = chars[0] == 0 ? 0 : 1;
        dp[1][0] = chars[0] == 1 ? 0 : 1;
        for (int i = 1; i < n; i++) {
            // 当前为0 ，则上一位的状态只能是0
            dp[i][0] = dp[i-1][0] + (chars[i] == '0' ? 0 : 1);
            // 当前状态为一 ，则前一个状态可以是0 1 ,但是取最小改变次数的
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + (chars[i] == '1' ? 0 : 1);
        }
        return Math.min(dp[n-1][0], dp[n-1][1]);
    }
}
