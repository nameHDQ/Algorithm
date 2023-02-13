package DayOne.simple;

public class N392 {
    public boolean isSubsequence(String s, String t) {

        int lenS = s.length(), lenT = t.length();
        if (lenS > lenT) return  false;
        int[][] dp = new int[lenT + 1][lenS + 1];
        for (int i = 1; i <= lenT; i++) {
            for (int j = 1; j <= lenS; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)){
                    dp[i][j] = dp[ i -1][ j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[ i -1][ j] , dp[ i][ j - 1]);
                }
            }
        }
        return dp[lenT][lenS] == s.length();
    }

    public static void main(String[] args) {
        new N392().isSubsequence("abc", "ahbgdc");
    }
}
