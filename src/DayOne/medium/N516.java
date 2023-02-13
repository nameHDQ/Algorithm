package DayOne.medium;

public class N516 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len; i > 0; i--) {
            for (int j = i; j <= len; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)){
                    if ( j - i <= 1){
                        dp[i][j] = j - i + 1;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        new N516().longestPalindromeSubseq("bbbab");
    }
}
