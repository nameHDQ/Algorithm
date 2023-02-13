package DayOne.medium;

public class N813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int len = nums.length;

        double[] sumPre = new double[len + 10];

        double[][] dp = new double[len + 10][len + 10];

        for (int i = 1; i <= len; i++) {
            sumPre[i] = sumPre[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                if (j == 1){
                    dp[i][j] = sumPre[i] / i;
                }else {
                    for (int l = 2; l <= i; l++) {
                        dp[i][j] = Math.max(dp[i][j], dp[l - 1][ j - 1] + (sumPre[i] - sumPre[l - 1]) / ( i - l + 1));
                    }
                }

            }
        }





        return dp[len][k];
    }
}
