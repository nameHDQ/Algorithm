package DayOne.simple;

public class N169 {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res){
                count++;
            }else {
                count--;
                if (count == 0){
                    res = nums[i];
                    count = 1;
                }
            }
        }
        return res;
    }
}
