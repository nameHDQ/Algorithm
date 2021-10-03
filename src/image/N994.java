package image;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hdq
 * @create 2021-08-27 12:17
 */
public class N994 {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] ==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        if (queue.isEmpty()){
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] ==1){
                        return -1;
                    }
                }
            }
            return 0;
        }
        int totalTime = -1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] nowIndex= queue.poll();
                for (int j = 0; j < dir.length; j++) {
                    if (nowIndex[0] + dir[j][0]>=0 && nowIndex[0] + dir[j][0]<grid.length
                    && nowIndex[1] + dir[j][1] >=0 && nowIndex[1] + dir[j][1] <grid[0].length){
                        if (grid[nowIndex[0] + dir[j][0]][nowIndex[1] + dir[j][1]] == 1){
                            grid[nowIndex[0] + dir[j][0]][nowIndex[1] + dir[j][1]] = 2;
                            queue.add(new int[]{nowIndex[0] + dir[j][0],nowIndex[1] + dir[j][1]});

                        }

                    }
                }
            }
            totalTime++;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] ==1){
                    return -1;
                }
            }
        }

        return totalTime;
    }

    public static void main(String[] args) {
        N994 n994 = new N994();
        int[][] grid = {{0}};
        System.out.println(n994.orangesRotting(grid));
    }

}
