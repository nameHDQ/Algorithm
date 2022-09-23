package DayOne.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            // 条件不足

            // 去重
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for (int j = i + 1 ; j < nums.length; j++) {

                //去重
                if ( j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }

                for (int k = j + 1; k < nums.length; k++) {
                    int third = nums.length - 1;
                    //去重
                    if ( k > j + 1 && nums[k] == nums[k-1]){
                        continue;
                    }
                    long tempSum = nums[i];
                    tempSum +=nums[j];
                    tempSum +=nums[k];
                    tempSum += nums[third];
                    while (k < third && tempSum > target){
                        third--;
                        tempSum = nums[i] + nums[j] + nums[k] + nums[third];
                    }
                    if (third == k) break;
                    if (tempSum == target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[third]);
                        result.add(temp);
                    }

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        new N18().fourSum(nums, -294967296);
    }
}
