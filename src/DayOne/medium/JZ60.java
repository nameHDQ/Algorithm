package DayOne.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JZ60 {

    int count = 0;
    Map<Integer, Double> map = new HashMap<>();
    public double[] dicesProbability(int n) {
        dfs(n, 0);
        int size = map.size();

        double[] res = new double[size];
        int index  = 0;
        for (int i = 0; i < n * 6; i++) {
            if (map.containsKey(i + 1)){
                res[index++] = map.get(i + 1) / count;
            }

        }



        return res;
    }

    public double[] dicesProbability1(int n) {

        int[][] dp= new int[n + 1][n * 6 + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n * 6; j++) {
                for (int k = 1; k <= Math.min(6,j); k++) {
                    dp[i][j] += dp[i - 1][j - k];

                }
            }
        }
        double sum = Arrays.stream(dp[n]).sum();

        int size = 0;
        for (int i = 1; i <= n * 6; i++) {
            if (dp[n][i] != 0){
                size++;
            }
        }
        double[] res = new double[size];
        size = 0;
        for (int i = 1; i <= n * 6; i++) {
            if (dp[n][i] != 0){
                res[size++] = dp[n][i] / sum;
            }
        }


        return res;
    }

    public void dfs(int n , int sum){
        if (n == 0){
            map.put(sum, map.getOrDefault(sum, 0D) + 1);
            count++;
            return;
        }
        for (int i = 1; i <= 6; i++) {
            dfs(n - 1, sum + i);
        }
    }

    public static void main(String[] args) {
        new JZ60().dicesProbability1(2);
    }
}
