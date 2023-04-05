package classLearning.acwing.baseClass.dp;

import java.util.Scanner;

public class N2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N = in.nextInt();
        int capacity = in.nextInt();
        int[] volume = new int[N];
        int[] price = new int[N];

        for (int i = 0; i < N; i++) {
            volume[i] = in.nextInt();
            price[i] = in.nextInt();
        }
        int[][] dp = new int[N + 1][capacity + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= volume[i - 1]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - volume[i - 1]] + price[i - 1]);
                }
            }
        }
        System.out.println(dp[N][capacity]);
    }
}
