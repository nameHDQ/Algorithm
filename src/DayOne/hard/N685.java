package DayOne.hard;


import Utils.UnionFind;

import java.util.Stack;

/**
 * @author hdq
 * @create 2022-03-07 16:49
 */
public class N685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] inDegree = new int[edges.length + 1];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < edges.length; i++) {
            if (inDegree[edges[i][1]] == 2) {
                stack.push(i);
            }
        }
        UnionFind uf = new UnionFind(edges.length + 1);
        if (stack.size() > 0) {
            int temp = stack.pop();
            if (uf.isTree(edges, temp)) {
                return edges[temp];
            }else {
                return edges[stack.pop()];
            }
        }
        // 第三种情况  有环
        uf = new UnionFind(edges.length + 1);
        return uf.getCycle(edges);
    }

    class UnionFind {

        final int[] parent;

        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootY] = rootX;

        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public boolean isTree(int[][] edges, int deletedEdge) {
            for (int i = 0; i < edges.length; i++) {
                if (i == deletedEdge) {
                    continue;
                }
                if (isConnected(edges[i][0], edges[i][1])) {
                    return false;
                }
                union(edges[i][0], edges[i][1]);
            }
            return true;
        }

        public int[] getCycle(int[][] edges) {
            for (int i = 0; i < edges.length; i++) {
                if (isConnected(edges[i][0], edges[i][1])) {
                    return edges[i];
                }
                union(edges[i][0], edges[i][1]);
            }
            return new int[2];
        }
    }
}
