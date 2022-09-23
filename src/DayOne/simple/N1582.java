package DayOne.simple;

public class N1582 {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] colSum = new int[m];
        int[] rowSum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colSum[j] += mat[i][j];
                rowSum[i] += mat[i][j];
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && colSum[j] == 1 && rowSum[i] == 1){
                    result++;
                }
            }
        }

        return result;
    }
}
