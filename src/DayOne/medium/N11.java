package DayOne.medium;

/**
 * @author hdq
 * @create 2021-12-07 12:57
 */
public class N11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int ans = 0;
        while (l < r){
            ans = Math.max(Math.min(height[l],height[r])*(r-l),ans);
            if (height[l] <= height[r]){
                l++;
            }else {
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        N11 n11 = new N11();
        int[] nums = {1,2,1};
        System.out.println(n11.maxArea(nums));
    }
}
