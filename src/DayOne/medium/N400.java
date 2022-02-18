package DayOne.medium;

/**
 * @author hdq
 * @create 2021-11-30 9:37
 */
public class N400 {
    public int findNthDigit(int n) {
        String str = "";
        for (int i = 1; i <= n; i++) {
            str +=i;
        }
        return str.charAt(n-1)-'0';
    }

    public static void main(String[] args) {
        N400 n400 = new N400();
        System.out.println(n400.findNthDigit(1));
    }
}
