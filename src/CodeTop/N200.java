package CodeTop;

import java.util.HashMap;
import java.util.Map;

public class N200 {

    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 初始化数值为1的都指向自己
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    parent.put(i * n + j, i * n + j);
                    rank.put(i * n + j, 0);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    if (i + 1 < m && grid[i + 1][j] == '1'){
                        union((i + 1) * n + (j), i * n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1'){
                        union((i) * n + (j + 1), i * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1'){
                        union(i * n + (j - 1) , i * n + j);
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == '1'){
                        union((i - 1) * n + j , i * n + j);
                    }
                }
            }
        }
        System.out.println(find(1));
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (parent.containsKey(i * n + j)){
                    if (find(i * n + j) == i * n + j){
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public Integer find(int x){

        if (x != parent.get(x)){
            parent.put(x,find(parent.get(x)));
        }
        return parent.get(x);
    }

    public void union(int left, int right){

        Integer leftP = find(left);
        Integer rightP = find(right);

        if (rightP != leftP){
            if (rank.get(rightP) > rank.get(leftP)){
                parent.put(leftP, rightP);
            }else if (rank.get(rightP) < rank.get(leftP)){
                parent.put(rightP, leftP);
            }else {
                parent.put(leftP, rightP);
                rank.put(rightP,rank.get(leftP) + 1);
            }
        }
    }

    public static void main(String[] args) {
        char[][] nums = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(new N200().numIslands(nums));
    }

}
