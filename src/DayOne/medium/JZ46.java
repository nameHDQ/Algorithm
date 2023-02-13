package DayOne.medium;

public class JZ46 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        if (str.length() == 1) return 1;

        int[] dp = new int[str.length()];
        dp[0] = 1;

        dp[1] = Integer.valueOf(str.substring(0, 2)) > 25 ? dp[0] : 2;

        for (int i = 2; i < str.length(); i++) {
            if (i + 1 <= str.length()){
                if (Integer.valueOf(str.substring(i - 1, i + 1)) <= 25 && Integer.valueOf(str.substring(i - 1, i + 1)) >= 10){
                    dp[i] = dp[i - 1] + dp[ i - 2];
                }else {
                    dp[i] = dp[ i - 1];
                }
            }else {
                dp[i] = dp[ i - 1];
            }
        }
        return dp[str.length() - 1];
    }

    public static void main(String[] args) {
        new JZ46().translateNum(624);
    }

}
