package DayOne.medium;

import java.util.*;

/**
 * @author hdq
 * @create 2021-10-22 10:15
 */
public class N229 {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        int keyValue = len/3;
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < len; i++) {
            if (map.get(nums[i]) == null){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            if (map.get(integer) > keyValue){
                list.add(integer);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        N229 n229 = new N229();
        int[] nums = {1,1,1,3,3,2,2,2};
        for (Integer integer : n229.majorityElement(nums)) {
            System.out.println(integer);
        }
    }
}
