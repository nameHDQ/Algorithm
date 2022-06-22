package weekcmplication.week294;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-05-22 10:14
 */
public class N2 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[][] temp = new int[n][2];
        for (int i = 0; i < n; i++) {
            temp[i][0] = capacity[i];
            temp[i][1] = rocks[i];
        }
        Arrays.sort(temp, (x, y) ->
                (x[0]-x[1])-(y[0]-y[1])
        );
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int needRocks = temp[i][0] - temp[i][1];
            if (needRocks <= additionalRocks) {
                ans++;
                additionalRocks -= needRocks;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new N2().maximumBags(new int[]{2,3,4,5}, new int[]{1,2,4,4}, 2);
    }
}
