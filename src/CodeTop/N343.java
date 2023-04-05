package CodeTop;

public class N343 {
    public int cuttingRope(int n) {


        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * (i - j));
                dp[i] = Math.max(dp[i], dp[i - j] * j);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new N343().cuttingRope(10));
    }
}
