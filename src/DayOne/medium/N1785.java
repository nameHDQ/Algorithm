package DayOne.medium;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N1785 {
    public int minElements(int[] nums, int limit, int goal) {

        Set<Integer> set = new HashSet<>();
        long sum = 0;
        for (int num : nums) {
            set.add(num);
            sum += num;
        }
        int count = 0;
        long ab = goal - sum;
        if (ab % limit == 0){
            return (int) Math.abs(ab / limit);
        }
        return (int) Math.abs(Math.abs(ab/ limit) + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,1};
         new N1785().minElements(nums, 3,-4);
    }
}
