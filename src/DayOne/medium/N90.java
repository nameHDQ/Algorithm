package DayOne.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @create 2021-12-12 14:00
 */
public class N90 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false,0, nums);
        return res;
    }
    public void dfs(boolean choosePre,int cur,int[] nums){
        if (cur == nums.length){
            res.add(new LinkedList<>(temp));
            return;
        }

        dfs(false,cur+1, nums);
        if (!choosePre && cur > 0 && nums[cur-1] == nums[cur]){
            return;
        }
        temp.add(nums[cur]);

        dfs(true,cur+1, nums);
        temp.remove(temp.size()-1);

    }

}
