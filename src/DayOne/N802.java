package DayOne;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-08-05 19:07
 */
public class N802 {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int []color = new int[n];
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (IsSafe(graph, color, i)){
                ans.add(i);
            }
        }
        return ans;
    }
    public  static boolean IsSafe(int[][] graph, int[] color, int i ){
        if (color[i] > 0){
//            是否安全
            if (color[i] == 2){
                return true;
            }
//            等于1不安全
            return false;
        }
        color[i] = 1;

        for (int j = 0; j < graph[i].length; j++) {
            if (!IsSafe(graph, color, graph[i][j])){
                return false;
            }
        }
        color[i] = 2;
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> ans = new LinkedList<>();
        ans = eventualSafeNodes(graph);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
