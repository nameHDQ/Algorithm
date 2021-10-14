package DayOne.medium;

/**
 * @author hdq
 * @create 2021-10-12 9:53
 */
public class N29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int result = 0;
        boolean negative;
        negative = (dividend ^ divisor) < 0;
        long lDividend = Math.abs(dividend);
        long lDivisor = Math.abs(divisor);
        for (int i = 31; i >=0 ; i--) {
            if ((lDividend >> i) >= lDivisor){
                result+= 1<<i;
                lDividend -=lDivisor<<i;
            }
        }
        return negative? -result:result;
    }

    public static void main(String[] args) {
        N29 n29 = new N29();
        System.out.println(n29.divide(100, 3));
    }
}
