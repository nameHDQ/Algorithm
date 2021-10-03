package DayOne;

/**
 * @author hdq
 * @create 2021-08-15 20:36
 * 超时了，没有保存访问状态，半成品
 */
public class N576 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] isVisited = new int[m][n];

        int maxnum = (int) Math.pow(10,9) + 7;
        return forwarMove(m, n, maxMove,startRow,startColumn, isVisited) % maxnum ;
    }
    public int forwarMove(int m, int n, int maxMove, int startRow, int startColumn,int[][] isVisited){
        if (maxMove < 0){
            return 0;
        }
        if (isOutside(m,n,maxMove,startRow,startColumn)){
            return 1;
        }
        return forwarMove(m, n, maxMove-1,startRow-1,startColumn, isVisited) +
                forwarMove(m, n, maxMove-1,startRow,startColumn-1, isVisited) +
                forwarMove(m, n, maxMove-1,startRow+1,startColumn, isVisited) +
                forwarMove(m, n, maxMove-1,startRow,startColumn+1, isVisited);
    }
    public boolean isOutside(int m, int n, int maxMove, int startRow, int startColumn){
        if (startRow < 0 || startRow >= m || startColumn <0 || startColumn >= n){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        N576 test = new N576();
        System.out.println(test.findPaths(1, 3, 3, 0, 1));
    }
}
