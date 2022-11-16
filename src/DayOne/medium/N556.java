package DayOne.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class N556 {
    public int nextGreaterElement(int n) {

        char[] chars = Integer.toString(n).toCharArray();
        int right = chars.length - 2;
        while (right >=0 && chars[right] > chars[right + 1]){
            right--;
        }
        if (right < 0){
            return -1;
        }
        int swapPos = chars.length - 1;
        while (swapPos >= 0 && chars[right] >= chars[swapPos]){
            swapPos--;
        }
        swap(chars, right, swapPos);
        reverse(chars, right + 1);
        long ans = Long.parseLong(new String(chars));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public void reverse(char[] nums, int i){
        int right = nums.length - 1;
        while (i <= right){
            char temp = nums[right];
            nums[right] = nums[i];
            nums[i] = temp;
            i++;
            right--;
        }
    }
    public void swap(char[] nums, int i, int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
