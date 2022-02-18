package DayOne.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hdq
 * @create 2021-12-09 10:28
 */
public class N200 {
    int count = 0;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] state  = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && state[i][j] == 0){
                    state[i][j] = 1;
                    bfs(i,j,grid,state);
                }
            }
        }

        return count;
    }
    public void bfs(int i,int j, char[][] grid, int[][] state){
        int[] loc = {i,j};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(loc);
        while (queue.size()>0){
            int[] tem = queue.remove();
            int[][] inx = {{1,0},{0,1},{-1,0},{0,-1}};
            for (int k = 0; k < inx.length; k++) {
                if (inx[k][0]+tem[0]>=0 && inx[k][0]+tem[0] <grid.length
                        &&inx[k][1]+tem[1]>=0 && inx[k][1]+tem[1] <grid[0].length){
                    int temp_i = inx[k][0]+tem[0];
                    int temp_j = inx[k][1]+tem[1];
                    if (state[temp_i][temp_j] == 0 && grid[temp_i][temp_j] == '1'){
                        int[] cur = {temp_i,temp_j};
                        queue.add(cur);
                        state[temp_i][temp_j] = 1;
                    }
                }
            }
        }
        count++;
    }

    public static void main(String[] args) {
        N200 n200 = new N200();
        char[][] grid = { {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
};
        System.out.println(n200.numIslands(grid));
    }
}
