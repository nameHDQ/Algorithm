package weekcmplication.doubleweek79;

import java.util.*;

/**
 * @author hdq
 * @create 2022-05-28 23:04
 */
public class N3 {
    public long maximumImportance(int n, int[][] roads) {

        int len = roads.length;
        Map<Integer,int[]> map = new HashMap<>();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < len; i++) {
            int from = roads[i][0];
            int to = roads[i][1];
            map.put(from, map.get(from) == null ? new int[]{to} : new int[]{to, map.get(from)[0]});
            if (graph[from] == null) {
                graph[from] = new ArrayList<>();
                graph[from].add(to);
            }
            if (graph[to] == null) {
                graph[to] = new ArrayList<>();
                graph[to].add(from);
            }
        }
        long sum = 0;

        return 0;
    }
}
