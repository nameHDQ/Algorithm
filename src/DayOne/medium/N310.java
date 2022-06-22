package DayOne.medium;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author hdq
 * @create 2022-04-06 12:24
 */
public class N310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new java.util.HashMap<>();
        // 初始化图
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new java.util.ArrayList<>());
            }
            List<Integer> list1 = map.get(edge[0]);
            list1.add(edge[1]);
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new java.util.ArrayList<>());
            }
            List<Integer> list2 = map.get(edge[1]);
            list2.add(edge[0]);
        }
        int level = Integer.MAX_VALUE;
        Map<Integer,List<Integer>> result = new java.util.HashMap<>();
        for (int i = 0; i < n; i++){
            int count = countLevel(map, i, n);
            if (count < level){
                level = count;
            }
            if (!result.containsKey(count)){
                result.put(count,new java.util.ArrayList<>());
            }
            List<Integer> list = result.get(count);
            list.add(i);
            result.put(count,list);
        }
        return result.get(level);
    }

    private int countLevel(Map<Integer, List<Integer>> map, int index, int n) {
        List<Integer> neb = map.get(index);
        if (neb == null || neb.size() == 0) {
            return 0;
        }
        boolean[] isVisited =new  boolean[n];
        int count = 0;
        Deque<Integer> deque = new java.util.ArrayDeque<>();
        deque.add(index);
        while (deque.size() > 0) {
            // 同一层的 ，把下一层的所有节点加入
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int cur = deque.poll();
                isVisited[cur] = true;
                List<Integer> list = map.get(cur);
                for (Integer next : list) {
                    if (isVisited[next] == false) {
                        isVisited[next] = true;
                        deque.add(next);
                    }
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] edgs = {{3,0},{3,1}, {3,2},{3,4},{5,4}};
        System.out.println(new N310().findMinHeightTrees(6, edgs));
    }
}
