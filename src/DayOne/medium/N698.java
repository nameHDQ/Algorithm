package DayOne.medium;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-06-12 16:49
 */
public class N698 {

    int[]  nums;
    int n;
    boolean result;
    int avg;
    public boolean canPartitionKSubsets(int[] nums, int k) {


        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        this.nums = nums;
        this.n = nums.length;
        this.result = false;
        this.avg =  sum / k;
        dfs(new int[k], 0);
        return result;
    }

    public void dfs(int[] buckets, int index){
        if (result){
            return;
        }
        if (index == n) {
//            int temp = buckets[0];
//            for (int i = 1; i < buckets.length; i++) {
//                if (avg != buckets[i]){
//                    this.result =false;
//                    return;
//                }
//            }
            this.result = true;
            return;
        }

        // 如果其中某个buc 大于均值  中断
        for (int bucket : buckets) {
            if (bucket > avg) return;
        }

        // 标注回溯
        for (int i = 0; i < buckets.length; i++) {
            // 第一个随便放
            if ( index == 0 && i > 0) return;
            if (buckets[i] + nums[index] > avg) {
                continue;
            }
            if (i > 0 && buckets[i] == buckets[i - 1]) continue;
            buckets[i] += nums[index];
            dfs(buckets, index + 1);
            buckets[i] -= nums[index];

        }
        return;
    }
}
