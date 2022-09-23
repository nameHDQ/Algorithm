package DayOne.medium;

import java.util.Random;

/**
 * @author hdq
 * @create 2022-06-09 9:46
 */
public class N497 {
    class Solution {

        private int len;
        private int[][] loc;

        int[] sum;
        private Random random;

        public Solution(int[][] rects) {
            random = new Random();
            len = rects.length;
            loc = rects;
            sum = new int[len + 1];
            for (int i = 1; i <= len; i++) {
                sum[i] = sum[i - 1] + (loc[i - 1][2] - loc[i - 1][0] + 1) * (loc[i - 1][3] - loc[i - 1][1] + 1);
            }
        }

        public int[] pick() {
            int temp = random.nextInt(sum[len]) + 1;
            int l = 0 , r = len;
            while (l < r){
                int mid = l + r >> 1;
                if (sum[mid] >= temp){
                    r = mid;
                }else {
                    l = mid +1;
                }
            }
            temp = r-1;
            int start = random.nextInt();
            int end = random.nextInt();
            return new int[]{start, end};
        }
    }

    public static void main(String[] args) {
        System.out.println(new Random());
    }
}
