package DayOne.medium;

public class N915 {
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int[] rightMin = new int[nums.length];
        rightMin[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            leftMax = Math.max(nums[i], leftMax);
            if (leftMax <= rightMin[i + 1]){
                return i + 1;
            }
        }
        return 0;
    }
}
