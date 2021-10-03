package DayOne;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2021-08-20 11:40
 */
public class N977 {
    public int[] sortedSquares(int[] nums) {
        int[] snums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            snums[i] = nums[i] * nums[i];
        }
        Arrays.sort(snums);
        return snums;
    }

    public static void main(String[] args) {
        N977 n977 = new N977();
        int[] nums = {-4,-1,0,3,10};
        String s =new String(Arrays.toString(n977.sortedSquares(nums)));
        System.out.println(s);
    }
}
