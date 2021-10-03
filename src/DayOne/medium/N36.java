package DayOne.medium;

/**
 * @author hdq
 * @create 2021-09-17 11:36
 */
public class N36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] count = new int[9];
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.'){
                    count[board[i][j]-'0'- 1]++;
                    if (count[board[i][j]-'0'- 1] >1 ){
                        return false;
                    }
                }

            }

        }
        for (int i = 0; i < board.length; i++) {
            int[] count = new int[9];
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.'){
                    count[board[j][i]-'0'- 1]++;
                    if (count[board[j][i]-'0' - 1] >1 ){
                        return false;
                    }
                }
            }
        }
        int[][] counts = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.'){
                    if (i<=2 &&j<=2){
                        counts[0][board[i][j]-'0'- 1]++;
                        if (counts[0][board[i][j]-'0'- 1] >1 ){
                            return false;
                        }
                    }
                    if (i<=2&&j<=5&&j>=3){
                        counts[1][board[i][j]-'0'- 1]++;
                        if (counts[1][board[i][j]-'0'- 1] >1 ){
                            return false;
                        }
                    }
                    if (i<=2&&j<=8&&j>=6){
                        counts[2][board[i][j]-'0'- 1]++;
                        if (counts[2][board[i][j]-'0'- 1] >1 ){
                            return false;
                        }
                    }
                    if (i>=3&&i<=5&&j<=2){
                        counts[3][board[i][j]-'0'- 1]++;
                        if (counts[3][board[i][j]-'0'- 1] >1 ){
                            return false;
                        }
                    }
                    if (i>=3&&i<=5&&j>=3&&j<=5){
                        counts[4][board[i][j]-'0'- 1]++;
                        if (counts[4][board[i][j]-'0'- 1] >1 ){
                            return false;
                        }
                    }
                    if (i>=3&&i<=5&&j>=6&&j<=8){
                        counts[5][board[i][j]-'0'- 1]++;
                        if (counts[5][board[i][j]-'0'- 1] >1 ){
                            return false;
                        }
                    }
                    if (i>=6&&i<=8&&j<=2){
                        counts[6][board[i][j]-'0'- 1]++;
                        if (counts[6][board[i][j]-'0'- 1] >1 ){
                            return false;
                        }
                    }
                    if (i>=6&&i<=8&&j>=3&&j<=5){
                        counts[7][board[i][j]-'0'- 1]++;
                        if (counts[7][board[i][j]-'0'- 1] >1 ){
                            return false;
                        }
                    }
                    if (i>=6&&i<=8&&j>=6&&j<=8){
                        counts[8][board[i][j]-'0'- 1]++;
                        if (counts[8][board[i][j]-'0'- 1] >1 ){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        N36 n36 = new N36();
    }
}
