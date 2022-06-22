package DayOne.hard;

/**
 * @author hdq
 * @create 2022-03-23 12:18
 */
public class N440 {

    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int counts = getCounts(cur, n);
            if (k >= counts) {
                k -= counts;
                cur++;
            }else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }

    private int getCounts(int cur, long n) {
        int counts = 0;
        int first = cur;
        int last = cur;
        while(first <= n) {
            counts +=  Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(new N440().findKthNumber(2, 2));
    }
}
