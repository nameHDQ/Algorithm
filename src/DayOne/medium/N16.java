package DayOne.medium;

import java.util.Arrays;

public class N16 {
    public int threeSumClosest(int[] nums, int target) {
        int minRes = 100000;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int first = i;

            int second = i + 1;
            int third = nums.length - 1;
            while (second < third){
                int temp = nums[first] + nums[second] + nums[third];

                if (temp == target){
                    return 0;
                }
                minRes = Math.abs(minRes - target) > Math.abs(temp - target) ? temp : minRes;
                if (temp> target){
                    third--;
                }else {
                    second++;
                }
            }

        }
        return minRes;
    }
}
