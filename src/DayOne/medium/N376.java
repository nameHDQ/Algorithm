package DayOne.medium;

import java.util.concurrent.ConcurrentHashMap;

public class N376 {
    public int wiggleMaxLength(int[] nums) {
//        int len = nums.length;
//        int[] up = new int[len];
//        int[] down = new int[len];
//        up[0] = 1; down[0] = 1;
//
//        for (int i = 1; i < nums.length; i++) {
//
//            if (nums[i] > nums[i-1]){
//
//                up[i] = Math.max(up[i - 1], down[i-1] + 1);
//                down[i] = down[i-1];
//            }else if (nums[i] < nums[i-1]){
//                up[i] = up[i - 1];
//                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
//            }else {
//                up[i] = up[i - 1];
//                down[i] = down[i-1];
//            }
//        }
//
//        return Math.max(down[len - 1], up[len - 1]);

        int len = nums.length;
        if (len < 2) return len;

        int prediff = nums[0] - nums[1];
        int res = prediff == 0?1:2;
        for (int i = 2; i < len; i++) {
            int diff = nums[i-1] - nums[i];
            if ((diff > 0 && prediff < 0)||(diff < 0 && prediff > 0)) {
                res++;
                prediff = diff;
            }
        }
        return res;
    }
}
