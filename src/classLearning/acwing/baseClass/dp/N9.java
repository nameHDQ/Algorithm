package classLearning.acwing.baseClass.dp;

import java.util.Scanner;

public class N9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int m = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        int n = Integer.parseInt(in.nextLine());
        String t = in.nextLine();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; ++j) {
            dp[0][j] = j;
        }


        for (int i = 1; i <= m; i++) {
            char s1 = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char t1 = t.charAt(j - 1);
                if (s1 == t1){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    //考虑删除，添加，添加A相当于删除B
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    // 替换，
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
