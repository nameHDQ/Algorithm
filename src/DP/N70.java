package DP;

/**
 * @author hdq
 * @create 2021-08-30 12:57
 */
public class N70 {
    public int climbStairs(int n) {
//        超时
//        if (n < 0){
//            return 0;
//        }
//        if (n == 0){
//            return 1;
//        }
//        return climbStairs(n-1)+climbStairs(n-2);
        int[] dp = new int[n+10];
        dp[1] = 1;
        dp[2] = 2;
        if (n<=2){
            return dp[n];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        N70 n70 = new N70();
        System.out.println(n70.climbStairs(1));
    }
}
