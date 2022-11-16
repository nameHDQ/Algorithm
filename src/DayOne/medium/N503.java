package DayOne.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class N503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        int maxIdx = 0;
        int max = nums[0];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i]){
                Integer pop = deque.pop();
                res[pop] = nums[i];
            }
            deque.push(i);
        }
        if (!deque.isEmpty()){
            for (int i = 0; i <= maxIdx; i++) {
                while (!deque.isEmpty() && nums[deque.peek()] < nums[i]){
                    Integer pop = deque.pop();
                    res[pop] = nums[i];
                }
            }
        }
        if (!deque.isEmpty()){
            for (Integer integer : deque) {
                res[integer] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-2,-3};
        new N503().nextGreaterElements(nums);
    }
}
