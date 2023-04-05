package DayOne.hard;

import java.util.HashMap;
import java.util.Map;

public class N1815 {
    Map<String , Integer> memo = new HashMap<>();
    public int maxHappyGroups1(int batchSize, int[] groups) {

        int n = batchSize;
        int[] cnt = new int[n];
        int ans = 0;
        for (int group : groups) {
            if (group % n == 0){
                ans++;
            }else {
                cnt[group % n]++;
            }
        }
        ans += backTrack(cnt, 0);
        return ans;
    }

    private int backTrack(int[] cnt, int left) {
//        String temp = inCode(cnt);

//        if (memo.containsKey(temp)){
//            return memo.get(temp);
//        }

        int ans = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0){
                int curLeft = (i + left) % cnt.length;
                cnt[i]--;
                int newAns = backTrack(cnt, curLeft);
                cnt[i]++;
                ans = Math.max(ans, newAns + (left == 0 ? 1 : 0));
            }
        }
//        memo.put(temp,ans);
        return ans;
    }
    public String inCode(int[] cnt){
        String temp = "";
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] >= 10){
                temp += cnt[i];
            }else {
                temp += "0" + cnt[i];
            }
        }
        return temp;
    }
    private Map<Long, Integer> f = new HashMap<>();
    private int size;
    public int maxHappyGroups(int batchSize, int[] groups) {
        size = batchSize;
        int ans = 0;
        long state = 0;
        for (int g : groups) {
            int i = g % size;
            if (i == 0) {
                ++ans;
            } else {
                state += 1l << (i * 5);
            }
        }
        ans += dfs(state, 0);
        return ans;
    }

    private int dfs(long state, int mod) {
        if (f.containsKey(state)) {
            return f.get(state);
        }
        int res = 0;
        for (int i = 1; i < size; ++i) {
            if ((state >> (i * 5) & 31) != 0) {
                int t = dfs(state - (1l << (i * 5)), (mod + i) % size);
                res = Math.max(res, t + (mod == 0 ? 1 : 0));
            }
        }
        f.put(state, res);
        return res;
    }


    public static void main(String[] args) {


        int[] cnt = {1,3,2,5,2,2,1,6};

        System.out.println(new N1815().maxHappyGroups1(4,cnt));



    }

}
