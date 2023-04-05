package classLearning.acwing.baseClass.dp;

import java.util.Arrays;
import java.util.Scanner;

public class N6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int N = in.nextInt();
        int[] dp = new int[N + 1];
        int[] volume = new int[N + 1];
        for (int i = 0; i < N; i++) {
            volume[i] = in.nextInt();
        }
        dp[1] = 1;
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (volume[i - 1] > volume[j - 1]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        System.out.println(res);
    }
//    10
//            -5 -7 -2 1 -9 -7 4 5 6 1
}
