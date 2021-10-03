package DayOne;

/**
 * @author hdq
 * @create 2021-08-25 13:56
 */
public class N695 {
    public int maxAreaOfIsland(int[][] grid) {

        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans = Math.max(ans,BFS(i,j,grid));
            }
        }


        return ans;
    }
    public int BFS(int cur_i, int cur_j,int[][] grid){
        if (cur_i<0 || cur_j<0 || grid[cur_i][cur_j] !=1 || cur_i == grid.length || cur_j == grid[0].length){
            return 0;
        }
        grid[cur_i][cur_j] = 0;
        int[] indexx = {0,0,1,-1};
        int[] indexy = {1,-1,0,0};
        int ans =1;
        for (int i = 0; i <4 ; i++) {
            int ur_i = cur_i+indexx[i];
            int ur_j = cur_j + indexy[i];
            ans+=BFS(ur_i,ur_j,grid);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid= {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        N695 n695 = new N695();
        System.out.println(n695.maxAreaOfIsland(grid));
    }

}