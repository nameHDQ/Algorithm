package CodeTop;

import java.util.*;

public class MS0812 {
    Map<Integer,Boolean> row = new HashMap<>();
    Map<Integer,Boolean> col = new HashMap<>();
    Map<Integer,Boolean> xie1 = new HashMap<>();
    Map<Integer,Boolean> xie2 = new HashMap<>();
    Deque<int[]> loc = new ArrayDeque<>();

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                row.put(i,true);
                col.put(j, true);
                xie1.put(i - j, true);
                xie2.put(i + j, true);
                loc.push(new int[]{i,j});
                dfs(n - 1,i,j, n);
                row.put(i,false);
                col.put(j, false);
                xie1.put(i - j, false);
                xie2.put(i + j, false);
                loc.pop();
            }
        }
        return res;
    }





    public void dfs(int cur, int x, int y, int len){
        if (cur == 0){
            List<String> temp = new ArrayList<>();
            for (int i = 1; i <= len; i++) {
                String str = "";
                for (int j = 1; j <= len; j++) {
                    str += ".";
                }
                temp.add(str);
            }
            for (int[] ints : loc) {
                int X = ints[0];
                int Y = ints[1];
                String s = temp.get(X - 1);
                char[] chars = s.toCharArray();
                chars[Y - 1] = 'Q';
                temp.set(X - 1, new String(chars));
            }
            res.add(temp);
            return;
        }
        for (int i = x; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (row.getOrDefault(i,false) || col.getOrDefault(j, false) || xie2.getOrDefault(i + j, false) || xie1.getOrDefault(i - j, false)){
                    continue;
                }
                row.put(i,true);
                col.put(j, true);
                xie2.put(i + j, true);
                xie1.put(i - j, true);
                loc.push(new int[]{i,j});
                dfs(cur - 1,i,j, len);
                row.put(i,false);
                col.put(j, false);
                xie2.put(i + j, false);
                xie1.put(i - j, false);
                loc.pop();
            }
        }

    }

    public static void main(String[] args) {


        double x = 3.34;
        double y = 3.33;
        System.out.println(x == y);

        System.out.println(new MS0812().solveNQueens(4));
    }
}
