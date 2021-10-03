package DayOne.medium;

/**
 * @author hdq
 * @create 2021-09-25 22:49
 */
public class N1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(),n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j-1);
                if (c1 == c2){
                    //相等，直接加一
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    //不相等，那么 i,j的子序列不变，比较各自分别加一时的情况
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        N1143 n1143 = new N1143();
        System.out.println(n1143.longestCommonSubsequence("abcde", "ace"));
    }
}
