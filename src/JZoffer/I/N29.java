package JZoffer.I;

import java.util.ArrayList;
import java.util.List;

public class N29 {
    public int[] spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0){
            return new int[0];
        }
        int top = 0, left = 0;
        int bottom = matrix.length - 1, right = matrix[0].length - 1;
        exchange(matrix, top, right, bottom, left, res);
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
    public void exchange(int[][] matrix, int top, int right, int bottom, int left, List<Integer> res){
        while (top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > bottom){
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left){
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < top){
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right){
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        new N29().spiralOrder(mat);
    }
}
