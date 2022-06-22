package weekcmplication.week297;

import java.util.Arrays;

/**
 * @author hdq
 * @create 2022-06-12 11:36
 */
public class N3 {
    int ans = Integer.MAX_VALUE;
    int[] cookies;
    int n;
    int k;
    public int distributeCookies(int[] cookies, int k) {

        this.k = k;
        this.cookies = cookies;
        this.n = cookies.length;
        Arrays.sort(cookies);

        backTrack(new int[k], n - 1);

        return ans;
    }

    public void backTrack(int[] buckets, int start){
        // 所有的分配完毕
        if (start < 0){
            int curValue = Integer.MIN_VALUE;
            for (int bucket : buckets) {
                curValue = Math.max(bucket, curValue);
            }
            ans = Math.min(curValue, ans);
            return;
        }

        // 剩下的饼干不够分了  桶数大于饼干数
//        int zeroCount = 0;
//        for (int bucket : buckets) {
//            if (bucket == 0) zeroCount++;
//        }
//        if (zeroCount > start + 1) return;

        // 分配过程 已经出现比现有答案还大的情况  直接中断

        for (int bucket : buckets) {
            if (bucket > ans){
                return;
            }
        }

        // 标准回溯
        for (int i = 0; i < k; i++) {
            // 优化 第一个不管分配给谁都是相同
            if (start == n - 1 && i > 0){
                return;
            }
            buckets[i] += cookies[start];
            backTrack(buckets, start - 1);
            buckets[i] -= cookies[start];
        }
        return;
    }

    public static void main(String[] args) {
        int[] a = {8,15,10,20,8};
        System.out.println(new N3().distributeCookies(a, 2));
    }
}
