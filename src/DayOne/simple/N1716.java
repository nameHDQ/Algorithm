package DayOne.simple;

/**
 * @author hdq
 * @create 2022-01-15 18:08
 */
public class N1716 {
    public int totalMoney(int n) {
        int weeks = n /7;
        int day = n%7;
        int sum = weeks*28 + 7*(weeks-1)*(weeks)/2;
        for (int i = 1; i <= day; i++) {
            sum+= i+weeks;
        }
        return sum;
    }

    public static void main(String[] args) {
        N1716 n1716 = new N1716();
        System.out.println(n1716.totalMoney(1));
    }
}
