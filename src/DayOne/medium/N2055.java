package DayOne.medium;

import java.util.Locale;

/**
 * @author hdq
 * @create 2022-03-08 8:48
 */
public class N2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] res = new int[queries.length];
        int[] preSum = new int[len];
        for (int i = 0, sum = 0; i < len; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        // 如果是* 那么此*左边最近的蜡烛坐标
        for (int i = 0, l = -1; i < len; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        // 如果是* 那么此*左边最近的蜡烛坐标
        for (int i = len - 1, r = -1; i >= 0 ; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        for (int i = 0; i < queries.length; i++) {
            // 左边找到靠右的第一个蜡烛
            int l = right[queries[i][0]];
            // 右边找到靠左的第一个蜡烛
            int r = left[queries[i][1]];
            // -1 表示左边或着右边没有蜡烛
            if (l == -1 || r == -1 || l > r) {
                res[i] = 0;
            } else {
                res[i] = preSum[r] - preSum[l];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        for (int i : new N2055().platesBetweenCandles("***|**|*****|**||**|*",
                new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}})) {
            System.out.println(i);
        }
    }
}
