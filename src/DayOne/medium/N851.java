package DayOne.medium;

import java.util.*;

/**
 * @author hdq
 * @create 2021-12-15 12:25
 */
public class N851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] lowThanI = new List[n];
        for (int i = 0; i < lowThanI.length; i++) {
            lowThanI[i] = new ArrayList<>();
        }
        //节点的入度
        int[] inEdge = new int[n];
        for (int[] ints : richer) {
            lowThanI[ints[0]].add(ints[1]);
            inEdge[ints[1]]++;
        }
        int[] ans = new int[n];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i;
        }
        Queue<Integer> queue =new ArrayDeque<>();
        for (int i = 0; i < inEdge.length; i++) {
            if (inEdge[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int x = queue.poll();
            for (Integer integer : lowThanI[x]) {
                if (quiet[ans[x]] < quiet[ans[integer]]){
                    ans[integer] =ans[x];
                }
                if (--inEdge[integer] == 0){
                    queue.offer(integer);
                }
            }
        }
        //dfs
//        for (int[] ints : richer) {
//            bigThanI[ints[1]].add(ints[0]);
//        }
//        int[] ans = new int[n];
//        Arrays.fill(ans, -1);
//        for (int i = 0; i < ans.length; i++) {
//            dfs(i, bigThanI, ans, quiet);
//        }
        return ans;
    }
    //dfs方式
    public void dfs(int i,List<Integer>[] bigThanI,int[] ans,int[] quiet){
        if (ans[i] != -1){
            return;
        }
        ans[i] =i;
        for (Integer bigThan : bigThanI[i]) {
            dfs(bigThan,bigThanI,ans,quiet);
            if (quiet[ans[bigThan]] < quiet[ans[i]]){
                ans[i] = ans[bigThan];
            }
        }
    }

}
