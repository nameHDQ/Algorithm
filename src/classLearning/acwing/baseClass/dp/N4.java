package classLearning.acwing.baseClass.dp;

import java.util.Scanner;

public class N4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N = in.nextInt();
        int capacity = in.nextInt();
        int[][] dp = new int[N + 1][capacity + 1];
        int[][] volume = new int[1005][1005];
        int[][] price = new int[1005][1005];
        int[]  size = new int[1005];
        for (int i = 0; i < N; i++) {
            size[i] = in.nextInt();
            for (int j = 0; j < size[i]; j++) {
                volume[i][j] = in.nextInt();
                price[i][j] = in.nextInt();
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k < size[i - 1]; k++) {
                    if (j >= volume[i - 1][k]){
                        //注意是max里的dp[i][j]，是和同组的里面比较。不是和不选比较
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - volume[i - 1][k]] + price[i -1][k]);
                    }

                }
            }
        }

        System.out.println(dp[N][capacity]);
    }
}
