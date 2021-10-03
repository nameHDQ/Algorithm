package image;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hdq
 * @create 2021-08-27 11:39
 */
public class N542 {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dis = new int[mat.length][mat[0].length];

        Queue<int[]> index = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0){
                    index.offer(new int[]{i,j});
                }
            }
        }
        if (index.isEmpty()){
            return mat;
        }
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!index.isEmpty()){
            Queue<int[]> side = new LinkedList<>();
            int[] location =index.poll();
            int i =location[0],j = location[1];
            for (int k = 0; k < move.length; k++) {
            }
        }


        return null;
    }
}
