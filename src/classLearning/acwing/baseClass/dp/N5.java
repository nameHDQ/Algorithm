package classLearning.acwing.baseClass.dp;

import java.util.Scanner;

public class N5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N = in.nextInt();
        int[][] dp = new int[N + 1][N + 1];
        int[][] volume = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j <= i){
                    volume[i][j] = in.nextInt();
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (i != j && j > 1){
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + volume[i- 1][j - 1];
                }else if (j == 1){
                    dp[i][j] = dp[i - 1][j] + volume[i - 1][j - 1];
                }else {
                    dp[i][j] = dp[i - 1][j - 1] + volume[i - 1][j - 1];
                }
                if (i == N){
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        System.out.println(res);
    }
}
