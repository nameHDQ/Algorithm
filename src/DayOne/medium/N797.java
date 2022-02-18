package DayOne.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-12-11 14:10
 */
public class N797 {
    List<List<Integer>> res= new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        temp.add(0);
        dfs(graph,0, graph.length-1);
        return res;
    }
    public void dfs(int[][] graph,int i,int n){
        if (i == n){
            List<Integer> cur = new LinkedList<>(temp);
            res.add(cur);
            return;
        }
        for (int num : graph[i]) {
            temp.add(num);
            dfs(graph,num,n);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        N797 n797 = new N797();
        int[][] grid = {{1},{}};
        n797.allPathsSourceTarget(grid);
    }

}
