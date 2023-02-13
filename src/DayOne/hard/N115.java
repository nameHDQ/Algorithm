package DayOne.hard;

public class N115 {
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (s.length() < t.length()){
            return 0;
        }
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= tLen; i++) {
            for (int j = 1; j <= sLen; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else {
                    dp[i][j] = dp[ i][ j - 1];
                }
            }
        }
        return dp[tLen][sLen];
    }

    public static void main(String[] args) {
        new N115().numDistinct("rabbbit", "rabbit");
    }
}
