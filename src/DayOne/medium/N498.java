package DayOne.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hdq
 * @create 2022-06-14 9:53
 */
public class N498 {
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int pos = 0;
        int[] res = new int[m * n];

        for (int i = 0; i < m + n - 1; i++) {
            // 奇数从上到下  偶数从下到上
            if (i % 2 == 0){
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - (m - 1);

                while ( x >= 0 && y < n){
                    res[pos++] = mat[x][y];
                    x--;
                    y++;
                }
            }else {
                int x = i < n ? 0 : i - (n - 1);
                int y = i < n ? i : n - 1;

                while ( x < m && y >= 0){
                    res[pos++] = mat[x][y];
                    x++;
                    y--;
                }
            }
        }
        return res;
    }
    public int[] findDiagonalOrder1(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Deque<int[]> deque = new ArrayDeque<>();


        deque.push(new int[]{0,0});

        return null;
    }
}
