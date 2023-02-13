package bishi.metaAPP;

public class N1 {
    public static int answer(int[] x) {
        int m = x.length;
        int[][] dp = new int[m + 1][2];
        dp[1][0] = -x[0];
        dp[1][1] = 0;
        for(int i = 2; i<= m; i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][ 1] - x[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] + x[i - 1] - 1);
        }
        return dp[m][1];
    }

    public static void main(String[] args) {
        int[] input = {3,6,9,1,2,6};
        N1.answer(input);
    }
}
