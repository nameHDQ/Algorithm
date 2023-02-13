package DayOne.hard;

import DayOne.simple.N169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N1697 {

    Map<Integer, Integer> parent = new HashMap<>();
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        int m = edgeList.length;
        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        for (int i = 0; i < n; i++) {
            parent.put(i, i);
        }
        Arrays.sort(index, (a, b) -> queries[a][2] - queries[b][2]);
        Arrays.sort(edgeList, (a,b)->{
            return a[2] - b[2];
        });
        int start = 0;
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < index.length; i++) {
            int limit = queries[index[i]][2];
            while (start < m && edgeList[start][2] < limit){
                union(edgeList[start][0],edgeList[start][1]);
                start++;
            }
            if (find(queries[index[i]][0]) == find(queries[index[i]][1])){
                ans[index[i]] = true;
            }
        }
        return ans;
    }

    public void union(int from, int to){
        from = find(from);
        to = find(to);
        parent.put(to, from);
    }

    public int find(int cur){
        if (cur != parent.get(cur)){
            parent.put(cur, find(parent.get(cur)));
        }
        return parent.get(cur);
    }
    public int find1(int cur){
        return cur = 5;
    }

    public static void main(String[] args) {
        new N1697().find1(6);
    }
}
