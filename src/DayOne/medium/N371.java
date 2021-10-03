package DayOne.medium;

/**
 * @author hdq
 * @create 2021-09-26 12:07
 */
public class N371 {
    public int getSum(int a, int b) {
        while (b!=0){
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        N371 n371 = new N371();
        System.out.println(n371.getSum(1, 2));
    }
}
