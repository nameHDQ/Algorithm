package DayOne.medium;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-12-20 10:06
 */
public class N475 {
    public int findRadius(int[] houses, int[] heaters) {
        int minR = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int i = binarySearch(heaters, house);
            int j = i+1;
            int leftDis = i<0?Integer.MAX_VALUE : house - heaters[i];
            int rightDis = j >= heaters.length? Integer.MAX_VALUE:heaters[j] - house;
            int curDis = Math.min(leftDis, rightDis);
            minR = Math.max(curDis, minR);
        }


        return minR;
    }
    int binarySearch(int[] nums,int target){
        int left = 0, right = nums.length-1;
        if (nums[left] > target){
            return -1;
        }
        while (left < right){
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] > target){
                right  = mid-1;
            }else {
                left = mid;
            }
        }
        return left;
    }
}
