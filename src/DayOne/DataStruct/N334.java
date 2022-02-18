package DayOne.DataStruct;


import javax.imageio.ImageTranscoder;

/**
 * @author hdq
 * @create 2022-01-12 10:46
 */
public class N334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length <3){
            return false;
        }
        int n = nums.length;
//        int[] leftMin = new int[n];
//        leftMin[0] = nums[0];
//        for (int i = 1; i < n; i++) {
//            leftMin[i] = Math.min(leftMin[i-1],nums[i]);
//        }
//        int[] rightMax = new int[n];
//        rightMax[n-1] = nums[n-1];
//        for (int i = n-2; i >=0 ; i--) {
//            rightMax[i] = Math.max(rightMax[i+1],nums[i]);
//        }
//        for (int i = 1; i < n-1; i++) {
//            if (leftMin[i-1] < nums[i] && nums[i] < rightMax[i+1]){
//                return true;
//            }
//        }
        int first = nums[0],second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > second){
                return true;
            }else if (nums[i] > first){
                second = nums[i];
            }else {
                first = nums[i];
            }
        }
        return false;
    }
}
