package DayOne.medium;

/**
 * @author hdq
 * @create 2021-09-25 22:20
 */
public class N583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i-1);
            for (int j = 1; j <= n ; j++) {
                char c2 = word2.charAt(j-1);
                if (c1 == c2){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int len = m+n-dp[m][n]*2;
        return len;
    }

    public static void main(String[] args) {
        N583 n583 = new N583();
        System.out.println(n583.minDistance("sea", "eat"));
    }
}
