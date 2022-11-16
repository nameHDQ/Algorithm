package DayOne.medium;

public class N96 {
    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        // 1-n 根节点情况
        for (int i = 1; i <= n; i++) {
            // 当i作为根节点时，所有的子树可能组合
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
