package niuniu.mediumClass;

public class N2 {

    /**
     * 注意不要抠细节，从宏观角度上去看每个元素的变化，找出规律和约束
     * @param mat
     * @param n
     * @return
     */
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here

        int top = 0, left = 0;
        int right = mat[0].length - 1, bottom = mat.length - 1;
        while (top < bottom){
            exchange(mat, top++, right--, bottom--, left++);
        }
        return mat;
    }

    public void exchange(int[][] mat, int top, int right, int bottom, int left){
        for (int i = 0; i < right - left; i++) {
            int temp = mat[top][left + i];
            mat[top][left + i] = mat[bottom - i][left] ;
            mat[bottom - i][left] = mat[bottom][right - i];
            mat[bottom][right - i] = mat[top + i][right];
            mat[top + i][right] = temp;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        new N2().rotateMatrix(mat, 3);
    }
}
