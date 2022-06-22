package DayOne.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hdq
 * @create 2022-05-03 20:58
 */
public class N54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0, right = col - 1;
        int sum = row * col;
        while (top <= Math.round(row/2) && right >= Math.round(col/2)) {
            for (int i = top; i <= right; i++) {
                if (res.size() == sum) return res;
                res.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= row - top - 1; i++) {
                if (res.size() == sum) return res;
                res.add(matrix[i][right]);
            }
            for (int i = right - 1; i >= top; i--) {
                if (res.size() == sum) return res;
                res.add(matrix[row - top - 1][i]);
            }
            for (int i = row - top - 2; i > top; i--) {
                if (res.size() == sum) return res;
                res.add(matrix[i][top]);
            }
            top++;
            right--;
        }
        return res;
    }

    public static void main(String[] args) {
        new N54().spiralOrder(new int[][]{{1,2,3, 4},{5,6,7,8},{9,10,11,12}});
    }
}
