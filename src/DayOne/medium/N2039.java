package DayOne.medium;

import java.util.*;

/**
 * @author hdq
 * @create 2022-03-20 11:54
 */
public class N2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        int ans = 0;
        boolean[] visited = new boolean[n];
        // 邻接边
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        // bfs求出最短路径
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int next : adj[cur]) {
                    if (visited[next]) {
                        continue;
                    }
                    queue.offer(next);
                    visited[next] = true;
                    int time = patience[next] * ((2 * level - 1) / patience[level]) + 2 * level + 1;
                    ans = Math.max(ans, time);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] edgs = {{0,1},{0,2},{1,2}};
        int[] pat = {0,10,10};
        N2039 n2039 = new N2039();
        System.out.println(n2039.networkBecomesIdle(edgs, pat));
    }
}
