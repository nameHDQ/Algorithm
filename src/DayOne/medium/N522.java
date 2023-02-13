package DayOne.medium;

import java.util.Map;

public class N522 {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() <= ans) continue;
            boolean noLcs = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;
                // j 是 i 的子序列
                if (isLCS(strs[j], strs[i])){
                    noLcs = false;
                }
            }
            if (noLcs){
                ans = strs[i].length();
            }
        }
        return ans;
    }
    public boolean isLCS(String s1, String s2){

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][ j - 1]);
                    dp[i][j] = Math.max(dp[i][j], dp[ i - 1][j - 1]);
                }
            }
        }
        if (dp[m][n] == n ){
            return true;
        }
        return  false;
    }

    public static void main(String[] args) {
        String[] strs = {"aaa","aaa","aa"};
        new N522().findLUSlength(strs);
    }
}
