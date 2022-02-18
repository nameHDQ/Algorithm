package DayOne.simple;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-12-03 10:49
 */
public class N1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        long count = Arrays.stream(nums).filter((num) -> {
            return num < 0;
        }).count();
        if (k <= count){
            for (int i = 0; i < k; i++) {
                nums[i] = -nums[i];
            }
            return Arrays.stream(nums).sum();
        }else {
            if ((k - count) %2 == 0){
                for (int i = 0; i < count; i++) {
                    nums[i] = -nums[i];
                }
                return Arrays.stream(nums).sum();
            }else {
                for (int i = 0; i < count; i++) {
                    nums[i] = -nums[i];
                }
                Arrays.sort(nums);
                nums[0] = -nums[0];
                return Arrays.stream(nums).sum();
            }
        }
    }

    public static void main(String[] args) {
        N1005 n1005 = new N1005();
        int[] arr = {2,-3,-1,5,-4};
        System.out.println(n1005.largestSumAfterKNegations(arr, 2));
    }
}
