package DayOne.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hdq
 * @create 2021-10-25 9:59
 */
public class N240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        N240 n240 = new N240();
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22}};
        System.out.println(n240.searchMatrix(matrix, 5));
    }
}
