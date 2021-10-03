package DayOne;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-08-29 11:49
 */
public class N1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int right = 1;
        int total=0;
        while (right <= arr.length){
            for (int i = 0;i+right<=arr.length; i++) {
                for (int j = i; j <i+right&&j<arr.length ; j++) {
                    total+=arr[j];
                }
            }
            right += 2;
        }
        return total;
    }

    public static void main(String[] args) {
        N1588 n1588 = new N1588();
        int[] arr ={10,11,12};
        System.out.println(n1588.sumOddLengthSubarrays(arr));
    }
}
