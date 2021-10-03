package DayOne;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-09-03 12:17
 */
public class M1714 {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] numsk = new int[k];
        for (int i = 0; i < k; i++) {
            numsk[i] = arr[i];
        }
        return numsk;
    }

    public static void main(String[] args) {
        M1714 m1714 = new M1714();
        int[] arr = {1,3,5,7,2,4,6,8};
        int[] ints = m1714.smallestK(arr, 4);
        for (int i :
                ints) {
            System.out.println(i);
        }
    }
}
