package DayOne.simple;

public class N509 {
    public int fib(int n) {

        int pre = 0;
        int now = 1;
        if (n == 0)return pre;
        if (n == 1) return now;

        for (int i = 2; i <= n; i++) {
            int temp = now;
            now += pre;
            pre = temp;
        }
        return now;
    }
}
