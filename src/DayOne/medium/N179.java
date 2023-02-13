package DayOne.medium;

import java.util.Arrays;

public class N179 {
    public String largestNumber(int[] nums) {


        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
        }

        Arrays.sort(strs, (a,b)->{
            return (b + a).compareTo(a + b);
        });
        String res = "";
        for (String str : strs) {
            res += str;
        }
        int index = 0;
        while (index < res.length() - 1 && res.charAt(index) == '0'){
            index++;
        }
        return res.substring(index);
    }
}
