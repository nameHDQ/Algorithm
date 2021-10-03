package bitOp;

import java.util.*;

/**
 * @author hdq
 * @create 2021-09-01 9:22
 */
public class N136 {
    public int singleNumber(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        Map<Integer,Boolean> map = new HashMap<>();
        Set l = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!l.contains(nums[i])){
                l.add(nums[i]);
                map.put(nums[i],true);
            }else {
                map.put(nums[i],false);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == true){
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        N136 n136 = new N136();
        int[] nums= {4,1,2,1,2};
        System.out.println(n136.singleNumber(nums));
    }
}
