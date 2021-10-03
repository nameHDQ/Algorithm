package DayOne;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hdq
 * @create 2021-09-13 9:31
 */
public class N447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        N447 n447 = new N447();
        int[][] points = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        System.out.println(n447.numberOfBoomerangs(points));
    }
}
