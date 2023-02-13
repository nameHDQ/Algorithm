package DayOne.medium;

public class N1764 {
    public boolean canChoose(int[][] groups, int[] nums) {

        int start = 0;
        int len = nums.length;

        for (int[] group : groups) {
            int groupLen = group.length;
            int left = start, right = start + groupLen - 1;
            while (right < len && left <= right) {
                if (nums[left] != group[left - start] || nums[right] != group[right - start] ) {
                    left++;
                    start++;
                    right++;
                } else {
                    left++;
                    right--;
                }
            }
            if (left <= right) {
                return false;
            }
            start = start + groupLen;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] groups = {{1,-1,-1},{3,-2,0}};
        int[] nums = {1,-1,0,1,-1,-1,3,-2,0};
        new N1764().canChoose(groups, nums);
    }
}
