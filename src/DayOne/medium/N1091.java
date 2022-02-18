package DayOne.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hdq
 * @create 2021-12-11 12:28
 */
public class N1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0){
            return -1;
        }
        if (grid.length == 1){
            return 1;
        }
        int len = grid.length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        int count = 1;
        boolean[][] visited = new boolean[len][len];
        visited[0][0] = true;
        while (queue.size() > 0){
            int que_size = queue.size();
            int[][] inx = {{-1,-1}, {-1,0}, {-1,1}, {0,1}
                    , {1,1}, {1,0}, {1,-1}, {0,-1}};
            for (int i = 0; i < que_size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < inx.length; j++) {
                    int[] newIdx = {cur[0] +inx[j][0],cur[1] +inx[j][01]};
                    if (newIdx[0] >=0 && newIdx[0] < len &&newIdx[1] >=0 && newIdx[1] < len
                            && grid[newIdx[0]][newIdx[1]] == 0 && !visited[newIdx[0]][newIdx[1]]){
                        queue.offer(newIdx);
                        visited[newIdx[0]][newIdx[1]] = true;
                        if (newIdx[0] == len-1 && newIdx[1] == len-1){
                            return count+1;
                        }
                    }
                }
                
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        N1091 n1091 = new N1091();
        int[][] grid = {{1,0,0},{1,1,0},{1,1,0}};
        System.out.println(n1091.shortestPathBinaryMatrix(grid));
    }
}
