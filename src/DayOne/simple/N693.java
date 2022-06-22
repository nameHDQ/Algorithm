package DayOne.simple;

/**
 * @author hdq
 * @create 2022-03-28 13:11
 */
public class N693 {
    public boolean hasAlternatingBits(int n) {


        while (n != 0) {
            int a = n & 1;
            int b = n & 2;
            if (a == b || (a == 1 && b == 2)) {
                return false;
            }
            n = n >> 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new N693().hasAlternatingBits(7));
    }
}
