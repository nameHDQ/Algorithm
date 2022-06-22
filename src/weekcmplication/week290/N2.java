package weekcmplication.week290;

/**
 * @author hdq
 * @create 2022-04-24 10:46
 */
public class N2 {
    public int countLatticePoints(int[][] circles) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int[] circle : circles) {
            int x = circle[0], y = circle[1], r = circle[2];
            if (x - r < left) left = x - r;
            if (x + r > right) right = x + r;
            if (y - r < low) low = y - r;
            if (y + r > high) high = y + r;
        }
        int ans = 0;
        for (int x = left; x <= right; x++) {
            for (int y = low; y <= high; y++) {
                for (int[] circle : circles) {
                    int x1 = circle[0], y1 = circle[1], r1 = circle[2];
                    int d1 = (x - x1) * (x - x1) + (y - y1) * (y - y1);
                    if (d1 <= r1 * r1) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
