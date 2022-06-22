package DayOne.medium;

/**
 * @author hdq
 * @create 2022-03-25 11:59
 */
public class N172 {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 5; i <= n; i+= 5) {
            for (int j = i; j % 5 == 0 ; j /= 5) {
                res++;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new N172().trailingZeroes(30));
    }
}
