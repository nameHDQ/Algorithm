package weekcmplication.doubleweek78;

/**
 * @author hdq
 * @create 2022-05-14 22:53
 */
public class N3 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int maxG = 0;
        int left = 0;
        int tempG = 0;
        int n = tiles.length;
        int dist = tiles[0][1] - tiles[0][0] + 1;
        if (dist > carpetLen) {
            return carpetLen;
        }else {
            tempG = dist;
        }
        for (int i = 1; i < n; i++) {
            int rightRight = tiles[i][1];
            int rightLeft = tiles[i][0];
            // 如果这个块的右方没有超过carcarpetLen覆盖的长度
            int leftLeft = tiles[left][0];
            int leftRight = tiles[left][1];
            int fugai = leftLeft + carpetLen - 1;
            if (fugai >= rightRight) {
                // 增加长度
                dist = rightRight - leftLeft + 1;
                tempG += dist;
                continue;
            }
            // 如果中间距离超过第一个的长度,重新更新起点，开始计数
            int startLen = leftRight - leftLeft + 1;
            if (rightLeft - fugai >0) {
                left = i;
                if (tempG > maxG) {
                    maxG = tempG;
                }
                tempG = 0;
                continue;
            }
            // 如果覆盖了第二个区间
            if (fugai >= rightLeft && fugai <= rightRight) {
                left = i;
                dist = fugai - rightLeft + 1;
                tempG += dist;
                if (tempG > maxG) {
                    maxG = tempG;
                }
                tempG = 0;
                continue;
            }
        }
        return maxG;
    }

    public static void main(String[] args) {
        int[][] tiles = {{1,5},{10,11},{12,18},{20,25},{30,32}};
        int carpetLen = 10;
        System.out.println(new N3().maximumWhiteTiles(tiles, carpetLen));

    }
}
