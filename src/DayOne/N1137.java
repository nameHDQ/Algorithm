package DayOne;

/**
 * @author hdq
 * @create 2021-08-08 20:01
 */
public class N1137 {
    public static int tribonacci(int n) {
        int a =0;
        int b =1;
        int c =1;
        if (n == 0){
            return 0;
        }
        if (n<3){
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            int temp = a+b+c;
            a = b;
            b = c;
            c =temp;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
    }
}
