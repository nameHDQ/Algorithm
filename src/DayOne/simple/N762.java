package DayOne.simple;

/**
 * @author hdq
 * @create 2022-04-05 14:24
 */
public class N762 {
    public int countPrimeSetBits(int left, int right) {

        int total = 0;
        for (int i = left; i <= right; i++) {
            int count = 0;
            int temp = i;
            while (temp != 0) {
                if (temp % 2 == 1) {
                    count++;
                }
                temp = temp >> 1;
            }
            if (isPrim(count)) {
                total++;
            }
        }
        return total;
    }

    private boolean isPrim(int count) {
        if (count == 1){
            return false;
        }
        if (count <= 3) {
            return true;
        }
        for (int i = 2; i < count; i++) {
            if (count % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new N762().countPrimeSetBits(6, 10);
    }
}
