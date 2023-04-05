package NIUKEReal;

public class N4 {


    public int maxS(int[] nums){

        int temp = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (temp <= 0 && nums[i] >= temp){
                temp = nums[i];
                if (temp > res){
                    res = temp;
                }
                continue;
            }
            if (temp + nums[i] >= 0){
                temp += nums[i];
                if (temp > res){
                    res = temp;
                }
            }else {
                if (temp > res){
                    res = temp;
                }
                temp = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5};
        System.out.println(new N4().maxS(nums));
    }
}
