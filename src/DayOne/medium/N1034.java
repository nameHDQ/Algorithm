package DayOne.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hdq
 * @create 2021-12-07 10:11
 */
public class N1034 {
    Queue<int[]> queue = new LinkedList<>();
    Queue<int[]> col_all  =new LinkedList<>();
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m =grid.length;
        int n = grid[0].length;
        //获取要染色节点之前的值
        int target_color = grid[row][col];
        //用map记忆访问过的节点，记忆化搜索
        int[][] map = new int[m][n];
        int[] temp = {row,col};
        map[row][col]++;
        queue.add(temp);
        while (queue.size()>0){
            //判断是否为边界节点
            int count = 0;
            int[] curNode = queue.remove();
            int[][] dex = {{0,1},{1,0},{-1,0},{0,-1}};
            for (int i = 0; i < dex.length; i++) {
                if (curNode[0]+dex[i][0]>=0 && curNode[0]+dex[i][0] < m
                        && curNode[1]+dex[i][1]>=0 && curNode[1]+dex[i][1] <n
                        && grid[curNode[0]+dex[i][0]][curNode[1]+dex[i][1]] == target_color
                        ){
                    int[] cur = {curNode[0]+dex[i][0],curNode[1]+dex[i][1]};
                    if (map[curNode[0]+dex[i][0]][curNode[1]+dex[i][1]] ==0){
                        queue.add(cur);
                    }
                    count++;
                    map[curNode[0]+dex[i][0]][curNode[1]+dex[i][1]]++;
                }
            }
            if (count < 4){
                col_all.add(curNode);
            }
        }
        while (col_all.size()>0){
            int[] a = col_all.remove();
            grid[a[0]][a[1]] = color;
        }

        return grid;
    }

    public static void main(String[] args) {
        N1034 n1034 = new N1034();
        int[][] arr = {{1,2,1,2,1,2},
                       {2,2,2,2,1,2},
                       {1,2,2,2,1,2}};
        for (int[] ints : n1034.colorBorder(arr, 1, 3, 1)) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println("");
        }
    }
}
