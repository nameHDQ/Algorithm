package DayOne.simple;

public class N1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int len = points.length;
        int minLen = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < len; i++) {
            int curX= points[i][0];
            int curY = points[i][1];
            if (curY == y | curX == x){
                int temp = Math.abs(curY - y) + Math.abs(curX - x);
                if (temp < minLen){
                    minLen = temp;
                    res = i;
                }
            }
        }
        return res;
    }
}
