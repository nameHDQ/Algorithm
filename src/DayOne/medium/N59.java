package DayOne.medium;

public class N59 {
    public int[][] generateMatrix(int n) {

        int[][] result= new int[n][n];
        // ji'shu
        int len = n /2;
        int num = 1;

        for (int i = 0; i < len; i++) {

            // top
            for (int top = i; top < n - i; top++) {
                result[i][top] = num++;
            }
            // right
            for (int right = i + 1; right < n - i; right++) {
                result[right][n- i -1] = num++;
            }
            // bottom
            for (int bottom = n - i - 1 -1; bottom >= i; bottom--){
                result[n- i -1][bottom] = num++;
            }
            // left
            for (int left = n - i - 1 - 1; left > i; left--) {
                result[left][i] = num++;
            }
        }
        if (n %2 != 0 ){
            result[n/2][n/2] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new N59().generateMatrix(1));
    }
}
