package bishi.metaAPP;

import java.util.ArrayDeque;
import java.util.Deque;

public class N3 {
    public static int answer(int[] x) {
        int len = x.length;
        int ans1 = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                ans1 = Math.max(ans1, Math.min(x[i],x[j]) * (j - i));
            }
        }
        ans1 = Math.abs(ans1);
        ans1 = Math.min(ans1, 100000);
        Deque<Integer> deque = new ArrayDeque<>();

        while (ans1 > 0){
            deque.push(ans1 % 9);
            ans1 = ans1 / 9;
        }
        int size = deque.size();
        if (size < 2){
            return 0;
        }
        int[] ans2 = new int[size];
        for (int i = 0; i < size; i++) {
            ans2[i] = deque.pop();
        }
        int[][] dp = new int[size + 1][2];
        dp[1][0] = -x[0];
        dp[1][1] = 0;
        for(int i = 2; i<= size; i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][ 1] - x[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] + x[i - 1] - 3);
        }
        return dp[size][1];
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,1,4,2,6};
        N3.answer(nums);
    }
}
