package DayOne.medium;

public class N474 {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            int[] zo = calZO(strs[i]);
            int zero = zo[0];
            int one = zo[1];
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    dp[j][k] =dp[j][k];
                    if (zero <= j && one <= k ){
                        dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }


    public int[] calZO(String str){
        int[] cal = new int[2];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0'){
                cal[0] += 1;
            }else {
                cal[1] += 1;
            }
        }
        return cal;
    }

}
