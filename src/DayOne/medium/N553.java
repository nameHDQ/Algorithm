package DayOne.medium;

/**
 * @author hdq
 * @create 2022-02-27 12:07
 */
public class N553 {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums.length == 1) {
            sb.append(nums[0]);
            return sb.toString();
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    sb.append(nums[i]);
                    sb.append("/");
                    if (nums.length > 2 ){
                        sb.append("(");
                    }
                }else if (i == nums.length - 1) {
                    sb.append(nums[i]);
                    if (nums.length > 2 ){
                        sb.append(")");
                    }
                }else {
                    sb.append(nums[i]);
                    sb.append("/");
                }
            }
        }
        return sb.toString();
    }
}
