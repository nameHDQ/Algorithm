package DayOne.medium;


/**
 * @author hdq
 * @create 2022-03-07 13:42
 */
public class N684 {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (uf.find(edge[0]) != uf.find(edge[1])) {
                uf.unionElements(edge[0], edge[1]);
            }else{
                return edge;
            }
        }
        return new int[0];
    }
    class UnionFind {

        private int[] parent; // parent[i]表示第i个元素所指向的父节点
        private int count;    // 数据个数

        // 构造函数
        public UnionFind(int count){
            parent = new int[count + 1];
            this.count = count;
            // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
            for( int i = 1 ; i <= count ; i ++ ){
                parent[i] = i;
            }
        }

        // 查找过程, 查找元素p所对应的集合编号
        // O(h)复杂度, h为树的高度
        private int find(int p){
            assert( p > 0 && p <= count );
            // 不断去查询自己的父亲节点, 直到到达根节点
            // 根节点的特点: parent[p] == p
            while( p != parent[p] )
                p = parent[p];
            return p;

            //第二种路径压缩算法
            //if( p != parent[p] )
            //parent[p] = find( parent[p] );
            //return parent[p];
        }

        // 查看元素p和元素q是否所属一个集合
        // O(h)复杂度, h为树的高度
        public boolean isConnected( int p , int q ){
            return find(p) == find(q);
        }

        // 合并元素p和元素q所属的集合
        // O(h)复杂度, h为树的高度
        public void unionElements(int p, int q){

            int pRoot = find(p);
            int qRoot = find(q);

            if( pRoot == qRoot )
                return;

            // 下面不同题目的合并操作可能不一样
            parent[pRoot] = qRoot;
        }
    }

}
