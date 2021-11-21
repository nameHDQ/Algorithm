package DayOne.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

/**
 * @author hdq
 * @create 2021-10-20 12:00
 */
public class N453 {
    public int minMoves(int[] nums) {
        int Min = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res+= num- Min;
        }
        return res;
    }

    public static void main(String[] args) {
        N453 n453 = new N453();
        int[] nums = {1,2,2};
        System.out.println(n453.minMoves(nums));
    }
}
