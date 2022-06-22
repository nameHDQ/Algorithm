package DayOne.hard;

/**
 * @author hdq
 * @create 2022-04-16 12:46
 */
public class N479 {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int max = (int) Math.pow(10, n) - 1;
        int ans = 0;
        for (int left = max; ans == 0; left--) {
            long number = left;
            // 构建完整的回文数
            for (int x = left; x > 0 ; x /= 10) {
                number = number * 10 + x % 10;
            }
            // 找到回文数的两个n长度的因子
            for (long x = max; x * x >= number; x--) {
                // 找到因子了
                if (number % x == 0) {
                    ans = (int) (number % 1337);
                    break;
                }
            }
        }
        return ans;
    }
}
