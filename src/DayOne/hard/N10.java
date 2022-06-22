package DayOne.hard;

/**
 * @author hdq
 * @create 2022-03-05 15:34
 */
public class N10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // i,j表示s的第i个字符和p的第j个字符匹配
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // *匹配0个,与*前面一个字符的前面相同
                    dp[i][j] = dp[i][j-2];
                    // 为啥不是s的第i-1个和p的第j-1个匹配，也可以，用i-1一样，因为如果i==i-1,效果相同，不等同样也不等
                    if (match(s, p, i, j-1)) {
                        dp[i][j] = dp[i][j] || dp[i-1][j]; // i-1 即前i-1个字符
                    }
                }else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }

        }
        return dp[m][n];
    }
    public boolean match(String s, String p, int i, int j) {
        if( i == 0){
            return false;
        }
        if (p.charAt(j-1) == '.') {
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }
}
