package DayOne.medium;

public class N775 {
    public boolean isIdealPermutation(int[] nums) {

        int minValue = nums[nums.length - 1];
        for (int i = nums.length - 3; i >= 0; i--) {

            if (nums[i] > minValue) {
                return false;
            }

            minValue = Math.min(minValue, nums[i + 1]);
        }
        return true;
    }
}
