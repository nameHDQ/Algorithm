package DayOne.medium;

import java.util.*;

public class N873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);
            hashMap.put(arr[i], i);
        }
        int ans = 0;
        for (int j = 1; j < n; j++) {
            for (int i = j - 1; i >= 0 ; i--) {
                int diff = arr[j] - arr[i];
                if (hashMap.containsKey(diff)){
                    Integer index = hashMap.get(diff);
                    if (index < i){
                        dp[i][j] = Math.max(dp[index][i] + 1, dp[i][j]);
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans >= 3 ? ans : 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        new N873().lenLongestFibSubseq(arr);
    }
}
