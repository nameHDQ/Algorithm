package DayOne.medium;

import java.util.Arrays;

public class N1590 {
    public int minSubarray(int[] nums, int p) {

        int sumAll = Arrays.stream(nums).sum();
        if (sumAll % p == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int len = -1;
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if ((sumAll - temp) % p == 0 ){

            }
        }


        return 0;
    }
}
