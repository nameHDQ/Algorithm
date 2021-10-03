package DayOne;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-08-07 19:06
 */
public class N457 {
    public boolean circularArrayLoop(int[] nums) {

//        for (int i = 0; i < n; i++) {
//            //如果是0 则不前进或者后退
//            if (nums[i] == 0){
//                continue;
//            }
//            //快慢指针
//            int slow = i;
//            int fast = next(nums,i);
//            while ((nums[slow] * nums[fast] > 0) &&((nums[slow] * nums[next(nums,fast)]) > 0)){
//                //判断距离是否大于1
//                if (slow == fast){
//                    if (slow != next(nums,fast)){
//                        return true;
//                    }else {
//                        break;
//                    }
//
//                }
//                slow = next(nums,slow);
//                fast = next(nums,next(nums,fast));
//            }
//            int add = i;
//            //对于之前访问的不满住条件的 环 置零标记
//            while (nums[add] * nums[next(nums,add)] >0){
//                int temp =add;
//                add = next(nums,add);
//                nums[temp] = 0;
//            }
//        }
        int n = nums.length;
        int temp  =0 ;
        for (int i = 0; i < n; i++) {
            int slow = i;
            int fast = next(nums,i);
            while (slow != fast ){
                slow = next(nums,slow);
                fast = next(nums,next(nums,fast));
            }
            if (slow != next(nums,fast)){
                temp =slow;
                break;
            }else {
                return false;
            }
        }
        while (nums[temp] * nums[next(nums,temp)]>0){
            temp = next(nums,temp);
        }
        return false;
    }
    public int next(int[] nums , int cur){
        int n =nums.length;
        return ((cur+nums[cur])%n+n)%n;
    }
}
