package weekcmplication.week290;

import java.util.*;

/**
 * @author hdq
 * @create 2022-04-24 11:00
 */
public class N3 {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] dp = new int[101];
        List<Integer>[] list = new List[100];
        for (int i = 0; i < 100; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] rectangle : rectangles) {
            int x = rectangle[0];
            int y = rectangle[1];
            dp[y]++;
            list[y].add(x);
        }
        for (int i =100; i > 0; i--) {
            dp[i-1] += dp[i];
            Collections.sort(list[i]);
        }
        int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int count = 0;
            for (int j = 0; j < list[y].size(); j++) {
                if (list[y].get(i) >= x) {
                    count = list[y].size() - j;
                }
            }
            res[y] = dp[y] - count;
        }


        return res;
    }
}
