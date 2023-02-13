package DayOne.medium;

public class N647 {
    public int countSubstrings(String s) {
        int length = s.length();
        int res = 0;
        boolean[][] dp = new boolean[length + 1][length + 1];
        for (int j = 1; j <= length; j++) {
            for (int i = 1; i <= j; i++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)){
                    if (j - i <= 1){
                        res++;
                        dp[i][j] = true;
                    }else {
                        if (dp[i + 1][j - 1]){
                            res++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return res;
    }
}
