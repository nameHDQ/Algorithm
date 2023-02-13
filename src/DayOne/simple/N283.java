package DayOne.simple;

public class N283 {
    public void moveZeroes(int[] nums) {
        int start = 0;
        int count = 0;
        int i = 0;
        for (int num : nums) {
            if (num == 0){
                count++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[start++] = nums[i];
            }
        }

        while (start < nums.length){
            nums[start++] = 0;
        }
        return;
    }
}
