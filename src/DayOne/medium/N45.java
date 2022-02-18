package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-16 10:04
 */
public class N45 {
    public int jump(int[] nums) {
//        int position = nums.length-1;
//        int step = 0;
//        while (position > 0){
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] + i >= position){
//                    position = i;
//                    step++;
//                    break;
//                }
//            }
//        }
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
