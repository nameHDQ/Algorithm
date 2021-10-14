package DayOne.simple;

/**
 * @author hdq
 * @create 2021-10-10 9:47
 */
public class N441 {
    public int arrangeCoins(int n) {
        long total = 0;
        int i = 1;
        for (; total <n ; i++) {
            total+=i;
        }
        if (total == n){
            return i-1;
        }
        return i-2;
    }

    public static void main(String[] args) {
        N441 n441 = new N441();
        System.out.println(n441.arrangeCoins(2147483647));
    }
}
