package DayOne.hard;

import java.util.Arrays;

/**{{1,2},{1,2},{2,2},{0,2},{2,1},{1,1},{1,2}}
 * @author hdq
 * @create 2022-02-28 9:08
 */
public class N1601 {
    public int maximumRequests(int n, int[][] requests) {
        int[] delta = new int[n];
        int ans = 0, m = requests.length;
        for (int mask = 0; mask < (1 << m); ++mask) {
            int cnt = Integer.bitCount(mask);
            if (cnt < ans) {
                continue;
            }
            Arrays.fill(delta, 0);
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    delta[requests[i][1]]++;
                    delta[requests[i][0]]--;
                }
            }
            boolean flag = true;
            for (int i : delta) {
                if (i != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    private int dfs(int[] count, int[][] requests, int cur, int num) {
        if (cur >= requests.length) {
            if (isRing(count)) {
                return num;
            }
            return 0;
        }

        // 不接受
        int res = dfs(count, requests, cur + 1, num);
        // 接受
        count[requests[cur][0]]--;
        count[requests[cur][1]]++;
        res = Math.max(res, dfs(count, requests, cur + 1, num + 1));
        //处理完回溯过来回复现场
        count[requests[cur][0]]++;
        count[requests[cur][1]]--;
        return res;
    }
    public boolean isRing(int[] count){
        for (int cur : count) {
            if (cur != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new N1601().maximumRequests(3, new int[][]
                {{1,2},{1,2},{2,2},{0,2},{2,1},{1,1},{1,2}}));
    }
}
