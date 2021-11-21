package DayOne.simple;

/**
 * @author hdq
 * @create 2021-11-04 10:14
 */
public class N367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1){
            return true;
        }
        for (long i = 1; i <= num/2; i++) {
            if (i*i == num){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        N367 n367 = new N367();
        System.out.println(n367.isPerfectSquare(14));
    }
}
