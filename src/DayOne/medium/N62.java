package DayOne.medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hdq
 * @create 2021-12-16 10:37
 */
public class N62 {
    int[] idx = {0,1};
    int[] idy = {1,0};
    public int uniquePaths(int m, int n) {
        if (m == 1&& n == 1){
            return 1;
        }
        int pathCount = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0; i <queueSize ; i++) {
                int[] cur = queue.poll();
                if (cur[0] == m-1 &&cur[1] == n-1){
                    pathCount++;
                    continue;
                }
                for (int j = 0; j < 2; j++) {
                    int[] newLoc = {cur[0] + idx[j],cur[1] + idy[j]};
                    if (newLoc[0]  >= m || newLoc[1] >= n){
                        continue;
                    }
                    queue.add(newLoc);
                }
            }
        }

        return pathCount;
    }

    public static void main(String[] args) {
        N62 n62 = new N62();
        System.out.println(n62.uniquePaths(3, 7));
    }
}
