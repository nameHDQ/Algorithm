package DayOne.medium;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-05-20 20:02
 */
public class N436 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] startAndIdx = new int[n][2];
        for (int i = 0; i < n; i++) {
            startAndIdx[i][0] = intervals[i][0];
            startAndIdx[i][1] = i;
        }
        Arrays.sort(startAndIdx,(x,y)->
            x[0] - y[0]
        );
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l =0, right = n-1;
            while (l < right){
                int mid = (l + right) >>1;
                if (startAndIdx[mid][0] >= intervals[i][1]) right = mid;
                else l = mid + 1;
            }
            if (startAndIdx[right][0] >= intervals[i][1]){
                ans[i] = startAndIdx[right][1];
            }else {
                ans[i] = -1;
            }
        }

        return ans;
    }
}
