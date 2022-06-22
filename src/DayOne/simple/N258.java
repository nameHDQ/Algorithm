package DayOne.simple;

/**
 * @author hdq
 * @create 2022-03-03 12:42
 */
public class N258 {
    public int addDigits(int num) {
        int sum = 0;
        while (num >0 ) {
            sum += num % 10;
            num /= 10;
            if (num == 0) {
                num = sum;
                if (sum < 10) {
                    break;
                }
                sum = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        N258 n258 = new N258();
        System.out.println(n258.addDigits(38));
    }
}
