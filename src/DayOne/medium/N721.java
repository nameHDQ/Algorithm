package DayOne.medium;

import java.util.*;

/**
 * @author hdq
 * @create 2022-03-25 13:22
 */
public class N721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int emailCount = 0;
        Map<String, Integer> emailToId = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, emailCount++);
                    emailToName.put(email, name);
                }
            }
        }
        UnionFind uf = new UnionFind(emailCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstId = emailToId.get(firstEmail);
            for (int i = 2; i < account.size(); i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToId.get(nextEmail);
                uf.unionElements(firstId, nextIndex);
            }
        }
        Map<Integer, List<String>> idToEmails = new HashMap<>();
        for (String email : emailToId.keySet()) {
            Integer index = uf.find(emailToId.get(email));
            List<String> account = idToEmails.getOrDefault(index, new ArrayList<>());
            account.add(email);
            idToEmails.put(index, account);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> emails : idToEmails.values()) {
            List<String> newAccount = new ArrayList<>();
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            newAccount.add(name);
            newAccount.addAll(emails);
            result.add(newAccount);
        }
        return result;
    }
    class UnionFind {

        private int[] rank;   // rank[i]表示以i为根的集合所表示的树的层数
        private int[] parent; // parent[i]表示第i个元素所指向的父节点
        private int count;    // 数据个数

        // 构造函数
        public UnionFind(int count){
            rank = new int[count];
            parent = new int[count];
            this.count = count;
            // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
            for( int i = 0 ; i < count ; i ++ ){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // 查找过程, 查找元素p所对应的集合编号
        // O(h)复杂度, h为树的高度
        private int find(int p){
            assert( p >= 0 && p < count );
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
            // 根节点小的说明 是和其他人共有的账户，合并合并到同一个账户即可
            if (pRoot > qRoot) {
                parent[pRoot] = qRoot;
            }else {
                parent[qRoot] = pRoot;
            }
        }
    }
}
