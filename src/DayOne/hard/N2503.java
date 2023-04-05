package DayOne.hard;


import java.util.HashMap;
import java.util.Map;

public class N2503 {

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Map<Integer, Integer> parent = new HashMap<>();
    int[] size;
//    public int[] maxPoints(int[][] grid, int[] queries) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int mn = m * n;
//        size = new int[mn];
//        int[][] outLines = new int[mn][3];
//        Arrays.fill(size, 1);
//        int len = queries.length;
//        Pair<Integer, Integer>[] pairs = new Pair[len];
//        for (int i = 0; i < len; i++) {
//            pairs[i] = new Pair<>(queries[i], i);
//        }
//        Arrays.sort(pairs, (a,b)->{
//            return a.getKey() - b.getKey();
//        });
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                outLines[i * n + j] = new int[]{grid[i][j], i, j};
//                parent.put(i * n + j, i * n + j);
//            }
//        }
//        Arrays.sort(outLines, (a,b)->{return a[0] - b[0];});
//        int[] ans = new int[pairs.length];
//        int index = 0;
//        for (Pair<Integer, Integer> pair : pairs) {
//            int query = pair.getKey();
//            for (; index < mn && outLines[index][0] < query; index++) {
//                int x = outLines[index][1], y = outLines[index][2];
//                for (int[] dir : dirs) {
//                    int newX = x + dir[0], newY = y + dir[1];
//                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] < query) {
//                        union(x * n + y, newX * n + newY);
//                    }
//                }
//            }
//            if (grid[0][0] < query) {
//                ans[pair.getValue()] = size[find(0)];
//            }
//        }
//        return ans;
//    }

    public int find(int cur){
        if (cur != parent.get(cur)){
            parent.put(cur, find(parent.get(cur)));
        }
        return parent.get(cur);
    }
    public void union(int from, int to){
        from = find(from);
        to = find(to);
        if (from == to){
            return;
        }
        parent.put(from, to);
        size[to] += size[from];

    }

//    public int[] maxPoints(int[][] grid, int[] queries) {
//        int m = grid.length, n = grid[0].length, mn = m * n;
//
//        // 并查集
//        fa = new int[mn];
//        for (int i = 0; i < mn; i++) fa[i] = i;
//        size = new int[mn];
//        Arrays.fill(size, 1);
//
//        // 矩阵元素从小到大排序，方便离线
//        int[][] a = new int[mn][3];
//        for (int i = 0; i < m; ++i)
//            for (int j = 0; j < n; ++j)
//                a[i * n + j] = new int[]{grid[i][j], i, j};
//        Arrays.sort(a, (p, q) -> p[0] - q[0]);
//
//        // 查询的下标按照查询值从小到大排序，方便离线
//        int k = queries.length;
//        Integer[] id = IntStream.range(0, k).boxed().toArray(Integer[]::new);
//        Arrays.sort(id, (i, j) -> queries[i] - queries[j]);
//
//        int[] ans = new int[k];
//        int j = 0;
//        for (int i : id) {
//            int q = queries[i];
//            for (; j < mn && a[j][0] < q; ++j) {
//                int x = a[j][1], y = a[j][2];
//                // 枚举周围四个格子，值小于 q 才可以合并
//                for (int[] d : dirs) {
//                    int x2 = x + d[0], y2 = y + d[1];
//                    if (0 <= x2 && x2 < m && 0 <= y2 && y2 < n && grid[x2][y2] < q)
//                        merge(x * n + y, x2 * n + y2); // 把坐标压缩成一维的编号
//                }
//            }
//            if (grid[0][0] < q)
//                ans[i] = size[find(0)]; // 左上角的连通块的大小
//        }
//        return ans;
//    }
//
//    // 并查集模板
//    private int find(int x) {
//        if (fa[x] != x) fa[x] = find(fa[x]);
//        return fa[x];
//    }
//
//    private void merge(int from, int to) {
//        from = find(from);
//        to = find(to);
//        if (from != to) {
//            fa[from] = to;
//            size[to] += size[from];
//        }
//    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{2,5,7},{3,5,1}};
        int[] que = {5,6,2};
//        new N2503().maxPoints(nums,que);
    }
}
