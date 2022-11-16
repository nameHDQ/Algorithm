package DayOne.simple;

public class N1800 {
    public int maxAscendingSum(int[] nums) {

        int res = nums[0];
        int temp = nums[0];
        int pre = nums[0];
        if (nums.length == 1) return res;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > pre) {
                temp += nums[i];
            }else {
                if (temp > res){
                    res = temp;
                }
                temp = nums[i];
            }
            pre = nums[i];
        }



        return res > temp ? res : temp;
    }

    public static void main(String[] args) {
        int[] nums= {10,20,30,5,10,50};
        new N1800().maxAscendingSum(nums);
    }
}
