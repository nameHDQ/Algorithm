package DayOne.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hdq
 * @create 2022-03-05 20:42
 */
public class N399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();
        UnionFind uf = new UnionFind(equationsSize * 2);

        // 第一步：构建并查集 uf 将变量值与id映射 使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> map = new HashMap<>(equationsSize * 2);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String x = equation.get(0);
            String y = equation.get(1);
            if (!map.containsKey(x)) {
                map.put(x, id++);
            }
            if (!map.containsKey(y)) {
                map.put(y, id++);
            }
            // value[i] 为 x 到 y 的值
            uf.union(map.get(x), map.get(y), values[i]);

        }
        // 第二步：查询
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);

            Integer xId = map.get(x);
            Integer yId = map.get(y);

            if (xId == null || yId == null) {
                res[i] = -1.0;
            } else {
                res[i] = uf.isConnected(xId, yId);

            }
        }
        return res;
    }
    private class UnionFind {
        private int[] parent;
        /**
         * 指向父节点的权值
         */
        private double[] weight;

        /**
         * 初始每个节点指向自己，并且权值为1 自己除以自己
         * @param size
         */
        public UnionFind(int size) {
            parent = new int[size];
            weight = new double[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(Integer x, Integer y, double value) {
            int xRoot = find(x);
            int yRoot = find(y);
            // 父节点相同 不需要合并
            if (xRoot == yRoot) {
                return;
            }
            // 合并
            parent[xRoot] = yRoot;
            weight[xRoot] = weight[y] * value / weight[x];
        }

        // 查找根节点
        private int find(Integer id) {
//            第二种路径压缩算法
            if( id != parent[id] ){
                // 更新父节点 和 权值
                int origin = parent[id];
                parent[id] = find( parent[id] );
                // 更新权值 为父节点的权值乘以当前节点的权值
                weight[id] *= weight[origin] ;
            }
            return parent[id];
        }

        public double isConnected(Integer x, Integer y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return weight[x] / weight[y];
            }
            return -1.0d;
        }
    }
}
