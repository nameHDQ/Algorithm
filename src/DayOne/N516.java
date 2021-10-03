package DayOne;

import static java.lang.Math.max;

/**
 * @author hdq
 * @create 2021-08-12 20:18
 * 递归式的DP
 * 还有未递归式的
 */
public class N516 {
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp= new int[n][n];

        return dpOfij(s,dp,0,n-1);
    }
    public static  int dpOfij(String s,int[][] dp, int i,int j){
        if (j < i){
            return 0;
        }
        if (dp[i][j] > 0){
            return dp[i][j];
        }
        if (i == j){
            dp[i][j] = 1;
            return 1;
        }
        if (s.charAt(i) == s.charAt(j)){
            return dp[i][j] = dpOfij(s,dp,i+1,j-1)+2;
        }
        return dp[i][j] = max(dpOfij(s,dp,i,j-1),dpOfij(s,dp,i+1,j));
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }

}
