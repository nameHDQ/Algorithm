package DayOne.medium;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-06-01 9:40
 */
public class N473 {
    public boolean makesquare(int[] matchsticks) {
//        int total = Arrays.stream(matchsticks).sum();
//        if (total % 4 != 0) {
//            return false;
//        }
//        int sum = total / 4;
//        int len = matchsticks.length;
//        Arrays.sort(matchsticks);
//        for (int i = 0, j = len - 1; i < j; i++,j--) {
//            int temp = matchsticks[i];
//            matchsticks[i] = matchsticks[j];
//            matchsticks[j] = temp;
//        }
//
//        int[] edges = new int[4];
//            return dfs(0 , matchsticks, edges, sum);


        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        int len = totalLen / 4, n = matchsticks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int s = 1; s < (1 << n); s++) {
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) {
                    continue;
                }
                int s1 = s & ~(1 << k);
                System.out.println(s1);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }

    private boolean dfs(int i, int[] matchsticks, int[] edges, int sum) {
        if (i == matchsticks.length){
            return true;
        }
        for (int j = 0; j < 4; j++) {
            edges[j] += matchsticks[i];
            if (edges[j] <= sum && dfs(i+1, matchsticks, edges, sum)){
                return true;
            }
            edges[j] -= matchsticks[i];
        }

        return false;
    }

    public static void main(String[] args) {
        new N473().makesquare(new int[]{1,1,2,2,2});
    }
}
