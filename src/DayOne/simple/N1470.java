package DayOne.simple;

public class N1470 {
    public int[] shuffle(int[] nums, int n) {

        int len = nums.length;
        int index = 0;
        int[] res = new int[len];
        for (int i = 0; i < len; i += 2) {
            res[i] = nums[index];
            res[i + 1] = nums[ len / 2 + (index++)];
        }
        return res;
    }

    public static void main(String[] args) {
        new N1470().shuffle(new int[]{2,5,1,3,4,7}, 3);
    }
}
