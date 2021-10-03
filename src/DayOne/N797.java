package DayOne;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-08-25 12:10
 */
public class N797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new LinkedList<>();
        List li = new LinkedList();
        li.add(0);
        proback(0,graph,list,li);
        return list;
    }
    public void proback(int i,int[][] graph,List<List<Integer>> list,List li){
        if (i == graph.length-1){
            List lic = new LinkedList();
            lic.addAll(li);;
            list.add(lic);
            return;
        }
        if (graph[i].length == 0){
            return;
        }
        for (int j = 0; j < graph[i].length; j++) {
            li.add(graph[i][j]);
            proback(graph[i][j],graph,list,li);
            li.remove(li.size()-1);
        }
    }

    public static void main(String[] args) {
        N797 n797 = new N797();
        int[][] grap = {{1,3},{2},{3},{}};
        System.out.println(n797.allPathsSourceTarget(grap).toString());
    }
}
