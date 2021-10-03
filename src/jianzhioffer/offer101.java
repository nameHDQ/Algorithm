package jianzhioffer;

/**
 * @author hdq
 * @create 2021-09-04 10:59
 */
public class offer101 {
    public int fib(int n) {
        int maxn = 1000000007;
        int[] dp = new int[101];
        dp[0] = 0;
        dp[1] = 1;
        if (n<=1){
            return dp[n];
        }
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] = dp[i] % maxn;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        offer101 offer101 = new offer101();
        System.out.println(offer101.fib(48));
    }
}
