package DayOne.medium;

public class N221 {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 遍历以此点开始的所有正方形的可能性
                if (matrix[i][j] == '1'){
                    maxLen = Math.max(maxLen, 1);
                    int len = Math.min(m - i,  n - j);
                    for (int k = 1; k < len; k++) {

                        boolean flag = true;
                        if (matrix[i + k][j + k] == '0'){
                            break;
                        }
                        for (int q = 0; q < k; q++) {
                            if (matrix[i + k][j + q] == '0' || matrix[i + q][j + k]== '0'){
                                flag = false;
                                break;
                            }
                        }
                        if (flag){
                            maxLen = Math.max(maxLen, k + 1);
                        }else{
                            break;
                        }
                    }
                }
            }
        }


        return maxLen * maxLen;

    }
}
