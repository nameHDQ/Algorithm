package DayOne;

/**
 * @author hdq
 * @create 2021-09-10 9:27
 */
public class N1894 {
    public int chalkReplacer(int[] chalk, int k) {
        if (chalk.length == 1){
            return 0;
        }
        long[] dp = new long[chalk.length];
        dp[0] = chalk[0];
        for (int i = 1; i < chalk.length; i++) {
            dp[i] = dp[i-1] + chalk[i];
        }
        while (dp[chalk.length-1] <= k){
            k -= dp[chalk.length-1];
        }
        if (k == 0){
            return 0;
        }
        for (int i = 0; i < dp.length; i++) {
            if (k == dp[i]){
                return i+1;
            }
            if (k < dp[i]){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        N1894 n1894 = new N1894();
        int[] chalk = {5,1,2};
        System.out.println(n1894.chalkReplacer(chalk, 22));
    }
}
