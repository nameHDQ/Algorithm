package DayOne.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-12-06 15:22
 */
public class N15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3){
            return null;
        }
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            int third = nums.length-1;
            if (first > 0 && nums[first] ==nums[first-1]){
                continue;
            }
            for (int second = first+1 ; second < nums.length; second++) {
                if (second > first+1 && nums[second] ==nums[second-1]){
                    continue;
                }
                while (second < third && (nums[first]+nums[third]+nums[second]) >0){
                    third--;
                }
                if (second == third){
                    break;
                }
                if (nums[first]+nums[third]+nums[second] == 0){
                    List<Integer> temp = new LinkedList<>();
                    temp.add(nums[first]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    res.add(temp);
                }
            }
        }

        return res;
    }
}
